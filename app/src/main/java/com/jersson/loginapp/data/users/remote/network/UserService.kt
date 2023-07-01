package com.jersson.loginapp.data.users.remote.network

import android.util.Log
import com.jersson.loginapp.data.users.remote.model.ListUsersResponse
import com.jersson.loginapp.data.users.remote.model.UserRequest
import com.jersson.loginapp.domain.model.ResponseApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserService @Inject constructor(
    private val api: UserApiClient
) {

    suspend fun getListUsers(): ListUsersResponse?{
        return withContext(Dispatchers.IO){
            val response = api.getListUsers()
            Log.e("getListUsers: ", response.body().toString())
            response.body()
        }
    }

    suspend fun createUser(user: UserRequest): ResponseApi{
        return withContext(Dispatchers.IO) {
            val response = api.createUser(user)
            return@withContext if (response.isSuccessful) {
                ResponseApi.SUCCESS
            } else {
                ResponseApi.ERROR
            }
        }
    }

    suspend fun loginUser(user: UserRequest): ResponseApi{
        return withContext(Dispatchers.IO){
            val response = api.loginUser(user)
            Log.e("loginUser: ", response.toString())
            return@withContext if (response.isSuccessful) {
                ResponseApi.SUCCESS
            } else {
                ResponseApi.ERROR
            }
        }
    }
}