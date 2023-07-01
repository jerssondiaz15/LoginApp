package com.jersson.loginapp.data.di

import android.content.Context
import androidx.room.Room
import com.jersson.loginapp.data.users.local.UserDataBase
import com.jersson.loginapp.data.users.local.UserRepository
import com.jersson.loginapp.data.users.local.datasource.UserDatabaseDataSource
import com.jersson.loginapp.data.users.remote.network.UserApiClient
import com.jersson.loginapp.domain.repository.IUserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    private const val USER_DATABASE_NAME = "user_database"

    @Provides
    @Singleton
    fun provideCoinDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, UserDataBase::class.java, USER_DATABASE_NAME)
            .build()

    @Provides
    @Singleton
    fun provideUserDao(db: UserDataBase) = db.userDao()

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideUserApiClient(retrofit: Retrofit): UserApiClient {
        return retrofit.create(UserApiClient::class.java)
    }

    @Provides
    fun provideUserRepository(
        userDatabaseDataSource: UserDatabaseDataSource
    ): IUserRepository {
        return UserRepository(
            userDatabaseDataSource = userDatabaseDataSource
        )
    }

    @Provides
    fun provideUserDatabaseDataSource(
        userDataBase: UserDataBase
    ): UserDatabaseDataSource {
        return UserDatabaseDataSource(
            userDataBase = userDataBase
        )
    }
}