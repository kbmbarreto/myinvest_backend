package br.com.lambdateam.myinvest.model

import javax.persistence.*

@Entity
@Table(name = "wallet")
data class WalletModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @Column(name = "wallet")
    var wallet: String,

    @Column(name = "description")
    var description: String,

    @ManyToOne
    @JoinColumn(name = "id_user")
    var idUser: UserModel
)
