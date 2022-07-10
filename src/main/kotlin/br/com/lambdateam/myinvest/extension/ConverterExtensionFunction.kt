package br.com.lambdateam.myinvest.extension

import br.com.lambdateam.myinvest.model.UserModel
import br.com.lambdateam.myinvest.model.response.PostUser
import br.com.lambdateam.myinvest.model.response.PutUser
import br.com.lambdateam.myinvest.model.response.UserResponse

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