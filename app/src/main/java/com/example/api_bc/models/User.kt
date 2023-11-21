package com.example.api_bc.models

import com.google.gson.annotations.SerializedName

class User(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("first_name")
    val firstName: String = "",
    @SerializedName("email")
    val email: String = "",
    @SerializedName("avatar")
    val avatar: String = ""
)
