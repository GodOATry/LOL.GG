package com.example.lol_gg.screen.home.profile


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lol_gg.R
import com.example.lol_gg.api.repositories.DataStoreRepository
import com.example.lol_gg.api.NetworkResult
import com.example.lol_gg.api.repositories.ProfileScreenRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository,
    private val profileScreenRepository: ProfileScreenRepository
) : ViewModel() {
    private val _isUser = mutableStateOf(false)
    val isUser: State<Boolean> = _isUser
    var validateUserName = mutableStateOf(true)
    var validateEmail = mutableStateOf(true)
    var validateArePasswordsEqual = mutableStateOf(true)
    var validatePassword = mutableStateOf(true)
    var validateConfirmPassword = mutableStateOf(true)
    var isPasswordVisible = mutableStateOf(false)
    var isConfirmPasswordVisible = mutableStateOf(false)
    var isProgressBarVisible = mutableStateOf(false)
    var passwordToRemember = ""
    val passwordRegex = "(?=.*\\d)(?=.*[A-Z])(?=.*[!@#\$%^&+=]).{8,}".toRegex()
    val emailRegex = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )
    val profileEvent = MutableSharedFlow<ProfileEvents>()
    val registrationEvent = MutableSharedFlow<ProfileEvents>()
    val signInEvent = MutableSharedFlow<ProfileEvents>()


    fun validateUsername(username: String): Boolean {
        validateUserName.value = username.isNotEmpty()
        return validateUserName.value
    }

    fun validateEmail(email: String): Boolean {
        if (email.isNotEmpty()) {
            validateEmail.value = emailRegex.matcher(email).matches()
        }
        return validateEmail.value
    }

    fun validatePassword(password: String): Boolean {
        if (password.isNotEmpty()) {
            passwordToRemember = password
            validatePassword.value = passwordRegex.matches(password)
        }

        return validatePassword.value
    }

    fun validateConfirmPassword(confirmPassword: String): Boolean {
        if (confirmPassword.isNotEmpty()) {
            validateConfirmPassword.value = passwordRegex.matches(confirmPassword)
            validateArePasswordsEqual.value = passwordToRemember == confirmPassword
        }
        return validateConfirmPassword.value && validateArePasswordsEqual.value
    }

    fun validateAllFields(
        username: String,
        email: String,
        password: String,
        confirmPassword: String
    ): Boolean {

        return if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            false
        } else {
            validateUsername(username) && validateEmail(email) && validatePassword(password) && validateConfirmPassword(
                confirmPassword
            )
        }
    }

    private fun changeProgressBarState() {
        isProgressBarVisible.value = !isProgressBarVisible.value
    }


     fun register(
        userName: String,
        email: String,
        password: String,
        confirmPassword: String,
    ) {
        viewModelScope.launch {
            if (validateAllFields(userName,email, password, confirmPassword)) {
                changeProgressBarState()
                when(val registerResult = profileScreenRepository.registerUser(userName,email,password)){
                    is NetworkResult.Success ->{
                        registrationEvent.emit(ProfileEvents.RegistrationSuccessful())
                        when(val sigInResult = profileScreenRepository.signInUser(email,password)){
                            is NetworkResult.Success -> {
                                changeProgressBarState()
                                registrationEvent.emit(ProfileEvents.SignInSuccessful())
                                //TODO in LG-25 and LG-26
                            }
                            is NetworkResult.Failure -> {
                                changeProgressBarState()
                                registrationEvent.emit(ProfileEvents.SignInUnSuccessful())
                            }
                        }
                    }
                    is NetworkResult.Failure ->{
                        changeProgressBarState()
                        registrationEvent.emit(ProfileEvents.RegistrationUnSuccessful())
                        //TODO create more exception notifiers when all code errors will be ready from backend
                    }
                }
            }
        }
    }

    fun isUserSignedIn(){
       viewModelScope.launch {
           val user = dataStoreRepository.getUserFromDataStore().first()
           _isUser.value = user != null
       }
    }

}

sealed class ProfileEvents {
    data class HttpException(val messageId: Int = R.string.HttpException) : ProfileEvents()
    data class RegistrationSuccessful(val messageId: Int=R.string.successful_registration):ProfileEvents()
    data class RegistrationUnSuccessful(val messageId: Int=R.string.unsuccessful_registration):ProfileEvents()
    data class SignInSuccessful(val messageId: Int=R.string.successful_sign_in):ProfileEvents()
    data class SignInUnSuccessful(val messageId: Int=R.string.unsuccessful_sign_in):ProfileEvents()
}