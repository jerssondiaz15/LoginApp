package com.jersson.loginapp.usecase

import com.jersson.loginapp.data.users.remote.UserRemoteRepository
import com.jersson.loginapp.domain.model.ResponseApi
import com.jersson.loginapp.domain.model.User
import com.jersson.loginapp.domain.usecase.CreateUserUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class CreateUserUseCaseTest {

    @RelaxedMockK
    private lateinit var userRemoteRepository: UserRemoteRepository

    lateinit var createUserUseCase: CreateUserUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        createUserUseCase = CreateUserUseCase(userRemoteRepository)
    }

    @Test
    fun `when the room create user`() = runBlocking {
        //Given
        val data = User()
        val res = ResponseApi.SUCCESS
        coEvery { userRemoteRepository.createUser(data) } returns res

        //When
        val response = createUserUseCase.invoke(data)

        //Then
        coVerify(exactly = 1) { userRemoteRepository.createUser(data) }
        assert(response == res)
    }

}