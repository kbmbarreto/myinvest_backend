package br.com.lambdateam.myinvest.model

import br.com.lambdateam.myinvest.enums.EarningType
import java.math.BigDecimal
import java.util.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "dividends")
data class DividendsAndEarningsModel (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "date")
    var date: Date,

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    var type: EarningType?,

    @ManyToOne
    @JoinColumn(name = "broker_id")
    var broker: BrokerModel? = null,

    @ManyToOne
    @JoinColumn(name = "company_id")
    var company: CompanyModel,

    @ManyToOne
    @JoinColumn(name = "stock_id")
    var companyStockCode: CompanyModel,

    @Column(name = "value", columnDefinition = "DECIMAL(7,2)")
    var value: BigDecimal,

    @ManyToOne
    @JoinColumn(name = "id_user")
    var idUser: UserModel
)