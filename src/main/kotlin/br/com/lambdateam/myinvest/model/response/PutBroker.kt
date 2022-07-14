package br.com.lambdateam.myinvest.model.response

import br.com.lambdateam.myinvest.model.UserModel

data class PutBroker (

    val id: Long,
    val broker: String,
    val idUSer: UserModel
)
