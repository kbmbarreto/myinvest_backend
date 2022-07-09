package br.com.lambdateam.myinvest.model

import br.com.lambdateam.myinvest.Enums.HavingType
import java.math.BigDecimal
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "movimentation")
data class HavingMovimentationModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "date")
    var date: Date,

    @ManyToOne
    @JoinColumn(name = "broker_id")
    var broker: BrokerModel,

    @ManyToOne
    @JoinColumn(name = "company_id")
    var company: CompanyModel,

    @ManyToOne
    @JoinColumn(name = "stock_code_id")
    var stockCode: CompanyModel,

    @Column(name = "having_type")
    @Enumerated(EnumType.STRING)
    var havingType: HavingType,

    @Column(name = "qtde")
    var qtde: Int,

    @Column(name = "price", columnDefinition = "DECIMAL(7,2)")
    var price: BigDecimal,

    @Column(name = "brute_value", columnDefinition = "DECIMAL(7,2)")
    var bruteValue: BigDecimal,

    @Column(name = "costs", columnDefinition = "DECIMAL(7,2)")
    var costs: BigDecimal,

    @Column(name = "net_value", columnDefinition = "DECIMAL(7,2)")
    var netValue: BigDecimal
)
