package br.com.lambdateam.myinvest.model.response

import br.com.lambdateam.myinvest.model.UserModel

data class PostBroker (

    val broker: String,
    val idUser: UserModel
)
