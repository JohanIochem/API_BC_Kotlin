package com.example.api_bc.iinterface

import com.example.api_bc.models.User
import retrofit2.http.GET

interface UserApi {
    @GET("users")
    suspend fun listRepos(): List<User>
}
