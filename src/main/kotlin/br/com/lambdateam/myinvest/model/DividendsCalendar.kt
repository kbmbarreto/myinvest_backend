package br.com.lambdateam.myinvest.model

import br.com.lambdateam.myinvest.enums.EarningType
import java.time.Month
import javax.persistence.*

@Entity
@Table(name = "dividends_calendar")
data class DividendsCalendar(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "month")
    var month: Month,

    @ManyToOne
    @JoinColumn(name = "stock_id")
    var stockCode: CompanyModel? = null,

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    var type: EarningType
)
