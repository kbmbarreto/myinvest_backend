package br.com.lambdateam.myinvest.model.response

data class PutUser (

    val id: Long,
    val userName: String,
    val email: String,
    val password: String
)
