package br.com.lambdateam.myinvest.extension

import br.com.lambdateam.myinvest.model.BrokerModel
import br.com.lambdateam.myinvest.model.UserModel
import br.com.lambdateam.myinvest.model.response.*

fun UserModel.toResponse(): UserResponse {
    return UserResponse(
        id = this.id,
        userName = this.userName,
        email = this.email,
        password = this.password
    )
}
fun PostUser.toModel(): UserModel {
    return UserModel(
        userName = this.userName,
        email = this.email,
        password = this.password
    )
}
fun PutUser.toUserModel(previousValue: UserModel): UserModel {
    return UserModel(
        id = previousValue.id,
        userName = this.userName,
        email = this.email,
        password = this.password
    )
}

fun BrokerModel.toResponse(): BrokerResponse {
    return BrokerResponse(
        id = this.id,
        broker = this.broker
    )
}
fun PostBroker.toModel(): BrokerModel {
    return BrokerModel(
        broker = this.broker
    )
}
fun PutBroker.toBrokerModel(previousValue: BrokerModel): BrokerModel {
    return BrokerModel(
        id = previousValue.id,
        broker = this.broker
    )
}