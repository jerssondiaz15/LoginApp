package com.jersson.loginapp.data.users.local.datasource

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jersson.loginapp.data.users.local.UserDataBase
import com.jersson.loginapp.data.users.local.model.DbUser

class UserDatabaseDataSource(
    private val userDataBase: UserDataBase
) {


    suspend fun getListDbUsers(): List<DbUser>{
        return userDataBase.userDao().getListDbUsers()
    }

    suspend fun deleteAllUsers(){
        userDataBase.userDao().deleteAllUsers()
    }

    suspend fun insertUser(dbMovie: DbUser){
        userDataBase.userDao().insertUser(dbMovie)
    }

    suspend fun getDbUser(email: String): DbUser{
        return userDataBase.userDao().getDbUser(email)
    }
}