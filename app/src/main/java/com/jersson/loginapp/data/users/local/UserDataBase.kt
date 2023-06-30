package com.jersson.loginapp.data.users.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jersson.loginapp.data.users.local.dao.UserDao
import com.jersson.loginapp.data.users.local.model.DbUser

@Database(
    entities = [
        DbUser::class
    ],
    version = 1
)
abstract class UserDataBase: RoomDatabase() {
    abstract fun userDao(): UserDao
}