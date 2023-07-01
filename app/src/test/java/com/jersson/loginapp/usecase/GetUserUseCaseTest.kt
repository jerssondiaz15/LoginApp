package com.jersson.loginapp.usecase

import com.jersson.loginapp.domain.model.ResponseApi
import com.jersson.loginapp.domain.model.User
import com.jersson.loginapp.domain.repository.IUserRepository
import com.jersson.loginapp.domain.usecase.CreateUserUseCase
import com.jersson.loginapp.domain.usecase.GetUserUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetUserUseCaseTest {

    @RelaxedMockK
    private lateinit var iUserRepository: IUserRepository

    lateinit var getUserUseCase: GetUserUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getUserUseCase = GetUserUseCase(iUserRepository)
    }

    @Test
    fun `when the room obtain user`() = runBlocking {
        //Given
        val data = User()
        coEvery { iUserRepository.getDbUser("jdiaz@gmail.com") } returns data

        //When
        val response = getUserUseCase.invoke("jdiaz@gmail.com")

        //Then
        coVerify(exactly = 1) { iUserRepository.getDbUser("jdiaz@gmail.com") }
        assert(response == data)
    }
}