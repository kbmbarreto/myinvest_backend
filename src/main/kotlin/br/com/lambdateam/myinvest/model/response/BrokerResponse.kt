package br.com.lambdateam.myinvest.model.response

import br.com.lambdateam.myinvest.model.UserModel

data class BrokerResponse(

    val id: Long?,
    val broker: String?,
    val idUser: UserModel
)