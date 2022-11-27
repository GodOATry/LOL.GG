package com.example.lol_gg

import com.example.lol_gg.api.NetworkResult
import com.example.lol_gg.api.repositories.HomeScreenRepository
import com.example.lol_gg.data.Info
import com.example.lol_gg.data.Match
import com.example.lol_gg.data.Metadata
import com.example.lol_gg.data.PlayerStatistics
import com.example.lol_gg.screen.home.HomeViewModel
import io.kotest.matchers.shouldBe
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.*
import org.junit.*



class HomeViewModelTest {
    private val dispatcher = StandardTestDispatcher()
    private val playerStatistics =  PlayerStatistics()
    private val listOfMatches =  listOf(Match(Metadata(), Info()))

    @MockK
    lateinit var homeScreenRepository: HomeScreenRepository

    private suspend fun providesViewModel(): HomeViewModel {
        val viewModel = HomeViewModel(homeScreenRepository)
        coEvery { homeScreenRepository.getPlayerMatchHistory("","EUN1") } returns NetworkResult.Success(
          listOfMatches )
        coEvery { homeScreenRepository.getPlayerStatistics("","EUN1") } returns NetworkResult.Success(
           playerStatistics
        )
        coEvery { homeScreenRepository.getPlayerMatchHistory("","BR1") } returns NetworkResult.Failure(null,TestException(),null)
        coEvery { homeScreenRepository.getPlayerStatistics("","BR1") } returns NetworkResult.Failure(null,TestException(),null)


        return viewModel
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
     fun `chooseRegion() should correctly change region`() = runTest{
        val viewModel = providesViewModel()
        viewModel.chosenRegion.value shouldBe "EUNE"
        viewModel.chooseRegion(0)
        viewModel.chosenRegion.value shouldBe "BR"
    }

    @Test
    fun `calculateWinRate should correctly calculate win rate`()= runTest {
        val viewModel = providesViewModel()
        viewModel.calculateWinRate(10,0) shouldBe 100
        viewModel.calculateWinRate(10,10) shouldBe 50
        viewModel.calculateWinRate(0,10) shouldBe 0


    }

    @Test
    fun `calculateGameDuration should correctly calculate game duration`()= runTest {
        val viewModel = providesViewModel()
        viewModel.calculateGameDuration(650L) shouldBe "10:50"
        viewModel.calculateGameDuration(609L) shouldBe "10:09"

    }

    @Test
    fun `downloadStatistics() should calculate set playerStatistics and info`()= runTest {
        val viewModel = providesViewModel()
        viewModel.downloadStatistics("")
        viewModel.userStatistics.value shouldBe playerStatistics
        viewModel.gameInfo.value[0] shouldBe listOfMatches[0].info
    }
    //TODO MESSAGE
//      I do not know how to collect flow from viewModel to check if function works correctly
//      I tried a few different approaches but none of them worked, maybe you have some idea how it
//      should be done.

//    @Test
//    fun `downloadStatistics() should fail correctly`()= runTest {
//        val viewModel = providesViewModel()
//        viewModel.chooseRegion(0)
//        var event = viewModel.homeEvent
//        val emittedEvents = mutableListOf<HomeEvents>()
//        val collectJob = launch {
//            event.collect { emittedEvents.add(it)}
//        }
//        viewModel.downloadStatistics("")
//        collectJob.cancel()
//
//    }





}