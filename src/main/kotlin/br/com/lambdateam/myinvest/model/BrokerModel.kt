package br.com.lambdateam.myinvest.model

import javax.persistence.*

@Entity
@Table(name = "brokers")
data class BrokerModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(name = "broker", length = 60)
    val broker: String
)
