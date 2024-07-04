package com.medina.login

import java.io.Serializable

data class Usuario(
    var username: String,
    var email: String,
    var password: String
) : Serializable
