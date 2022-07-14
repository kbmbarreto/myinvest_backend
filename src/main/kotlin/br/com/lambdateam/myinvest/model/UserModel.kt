package br.com.lambdateam.myinvest.model

import javax.persistence.*

@Entity
@Table(name = "users")
data class UserModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "username", length = 60)
    var userName: String,

    @Column(name = "email", length = 75)
    var email: String,

    @Column(name = "password", length = 256)
    var password: String
)
