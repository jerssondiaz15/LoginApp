package com.jersson.loginapp.domain.usecase

import com.jersson.loginapp.data.users.remote.UserRemoteRepository
import com.jersson.loginapp.domain.model.User
import com.jersson.loginapp.domain.repository.IUserRepository
import javax.inject.Inject

class GetListUsersUseCase @Inject constructor(
    private val iUserRepository: IUserRepository,
    private val userRepository: UserRemoteRepository
) {
    suspend operator fun invoke(): List<User>{
        val listDbUsers = iUserRepository.getListDbUsers()
        val listUsers = userRepository.getListUsers()
        if (listDbUsers.isNotEmpty()){
            return listDbUsers
        } else {
            listUsers?.map {
                iUserRepository.insertUser(it)
            }
            return listUsers!!
        }
    }
}