package com.example.lol_gg

import com.example.lol_gg.screen.profile.ProfileViewModel
import io.kotest.*
import io.kotest.matchers.shouldBe
import io.mockk.MockKAnnotations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.*

class ProfileViewModelTest {
    private val dispatcher = StandardTestDispatcher()


    private fun providesViewModel(): ProfileViewModel {
        return ProfileViewModel()
    }

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        MockKAnnotations.init(this)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }


    @Test
    fun `validateUsername() should return correct values`(){
        val wrongUsername = ""
        val correctUserName = "Main"
        val viewModel = providesViewModel()
        viewModel.validateUsername(wrongUsername) shouldBe false
        viewModel.validateUsername(correctUserName) shouldBe true

    }

    @Test
    fun `validateEmail() should return correct values`(){
        val emptyEmail = ""
        val wrongEmail = "maciek@"
        val correctEmail = "maciek@wp.pl"
        val viewModel = providesViewModel()
        viewModel.validateEmail(emptyEmail) shouldBe true
        viewModel.validateEmail(wrongEmail) shouldBe false
        viewModel.validateEmail(correctEmail) shouldBe true
    }
    @Test
    fun `validatePassword() should return correct values`(){
        val emptyPassword = ""
        val wrongPassword = "Maciek!"
        val correctPassword = "Maciek!12"
        val viewModel = providesViewModel()
        viewModel.validatePassword(emptyPassword) shouldBe true
        viewModel.validatePassword(wrongPassword) shouldBe false
        viewModel.validatePassword(correctPassword) shouldBe true
    }
    @Test
    fun `validateConfirmPassword() should return correct values`(){
        val emptyConfirmPassword = ""
        val wrongConfirmPassword = "Maciek!"
        val correctConfirmPassword = "Maciek!12"
        val viewModel = providesViewModel()
        viewModel.passwordToRemember = correctConfirmPassword
        viewModel.validateConfirmPassword(emptyConfirmPassword) shouldBe true
        viewModel.validateConfirmPassword(wrongConfirmPassword) shouldBe false
        viewModel.validateConfirmPassword(correctConfirmPassword) shouldBe true
    }
    @Test
    fun `validateAllFields() should return correct values`(){
        val emptyValue = ""
        val correctEmail = "maciek@wp.pl"
        val correctPassword = "Maciek!12"
        val correctUserName = "Main"
        val viewModel = providesViewModel()
        viewModel.passwordToRemember = correctPassword
        viewModel.validateAllFields(emptyValue,emptyValue,emptyValue,emptyValue) shouldBe false
        viewModel.validateAllFields(correctUserName,emptyValue,correctPassword,correctPassword) shouldBe false
        viewModel.validateAllFields(correctUserName,correctEmail,correctPassword,emptyValue) shouldBe false
        viewModel.validateAllFields(correctUserName,correctEmail,correctPassword,correctPassword) shouldBe true

    }


}