package br.com.lambdateam.myinvest.repository

import br.com.lambdateam.myinvest.model.BrokerModel
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface BrokerRepository : JpaRepository <BrokerModel, Long> {

    override fun findById(id: Long): Optional<BrokerModel>
}