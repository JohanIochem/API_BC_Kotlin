package com.example.api_bc.services

import android.util.Log
import com.example.api_bc.iinterface.UserApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.api_bc.models.User

class BusinessCaseUserService : UserService {
    private val api: UserApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.215.165")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(UserApi::class.java)
    }

    override suspend fun fetchUsers(): List<User> {
        return withContext(Dispatchers.IO) {
            try {
                val repos = api.listRepos()
                Log.d("GithubRepoService", "repo fetched : $repos")
                repos
            } catch (ex: HttpException) {
                Log.e("GithubRepoService", "Http exception : ${ex.message()}", ex)
                emptyList()
            }
        }
    }
}
