package com.jersson.loginapp.domain.usecase

import com.jersson.loginapp.data.users.remote.UserRemoteRepository
import com.jersson.loginapp.domain.model.ResponseApi
import com.jersson.loginapp.domain.model.User
import javax.inject.Inject

class CreateUserUseCase @Inject constructor(
    private val userRemoteRepository: UserRemoteRepository
) {
    suspend operator fun invoke(user: User): ResponseApi {
        return userRemoteRepository.createUser(user)
    }
}