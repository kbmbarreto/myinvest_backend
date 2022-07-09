package br.com.lambdateam.myinvest.model

import javax.persistence.*

@Entity
@Table(name = "company")
data class CompanyModel (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "company_name")
    var companyName: String,

    @Column(name = "sector")
    var sector: String,

    @Column(name = "sub_sector")
    var subSector: String,

    @Column(name = "stock_code")
    var stockCode: String
)
