package com.example.api_bc.services

import com.example.api_bc.models.User

interface UserService {
    suspend fun fetchUsers(): List<User>
}