package com.jersson.loginapp.data.users.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jersson.loginapp.data.users.local.model.DbUser

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table")
    suspend fun getListDbUsers(): List<DbUser>

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUsers()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(dbMovie: DbUser)

    @Query("SELECT * FROM user_table WHERE email = :email")
    suspend fun getDbUser(email: String): DbUser

}