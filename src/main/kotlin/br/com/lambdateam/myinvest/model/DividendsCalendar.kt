package br.com.lambdateam.myinvest.model

import br.com.lambdateam.myinvest.Enums.EarningType
import java.time.Month
import javax.persistence.*

@Entity
@Table(name = "users")
data class DividendsCalendar(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(name = "username", length = 60)
    val month: Month,
    @Column(name = "email", length = 75)
    val having: String,
    @Column(name = "password", length = 256)
    val earningType: EarningType
)
