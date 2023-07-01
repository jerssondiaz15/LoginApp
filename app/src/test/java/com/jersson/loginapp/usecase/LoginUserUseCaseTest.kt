package com.jersson.loginapp.usecase

import com.jersson.loginapp.data.users.remote.UserRemoteRepository
import com.jersson.loginapp.domain.model.ResponseApi
import com.jersson.loginapp.domain.model.User
import com.jersson.loginapp.domain.usecase.GetUserUseCase
import com.jersson.loginapp.domain.usecase.LoginUserUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class LoginUserUseCaseTest {

    @RelaxedMockK
    private lateinit var userRemoteRepository: UserRemoteRepository

    lateinit var loginUserUseCase: LoginUserUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        loginUserUseCase = LoginUserUseCase(userRemoteRepository)
    }

    @Test
    fun `when the api can login`() = runBlocking {
        //Given
        val data = User()
        val res = ResponseApi.SUCCESS
        coEvery { userRemoteRepository.loginUser(data) } returns res

        //When
        val response = loginUserUseCase.invoke(data)

        //Then
        coVerify(exactly = 1) { userRemoteRepository.loginUser(data) }
        assert(response == res)
    }
}