package com.jersson.loginapp.domain.usecase

import com.jersson.loginapp.domain.model.User
import com.jersson.loginapp.domain.repository.IUserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val iUserRepository: IUserRepository
) {
    suspend operator fun invoke(password: String): User? {
        return iUserRepository.getDbUser(password)
    }

}