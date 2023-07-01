package com.jersson.loginapp.usecase

import com.jersson.loginapp.data.users.remote.UserRemoteRepository
import com.jersson.loginapp.domain.model.User
import com.jersson.loginapp.domain.repository.IUserRepository
import com.jersson.loginapp.domain.usecase.GetListUsersUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetListUsersUseCaseTest {

    @RelaxedMockK
    private lateinit var iUserRepository: IUserRepository

    @RelaxedMockK
    private lateinit var userRepository: UserRemoteRepository

    lateinit var getListUsersUseCase: GetListUsersUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getListUsersUseCase = GetListUsersUseCase(iUserRepository, userRepository)
    }

    @Test
    fun `when the api return data`() = runBlocking {
        //Given
        val data = listOf<User>()
        coEvery { userRepository.getListUsers() } returns data

        //When
        val response = getListUsersUseCase.invoke()

        //Then
        coVerify(exactly = 1) { userRepository.getListUsers() }
        assert(response == data)
    }

    @Test
    fun `when the room return data`() = runBlocking {
        //Given
        val data = listOf<User>()
        coEvery { iUserRepository.getListDbUsers() } returns data

        //When
        val response = getListUsersUseCase.invoke()

        //Then
        coVerify(exactly = 1) { iUserRepository.getListDbUsers() }
        assert(response == data)
    }
}