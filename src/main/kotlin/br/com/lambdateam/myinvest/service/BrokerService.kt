package br.com.lambdateam.myinvest.service

import br.com.lambdateam.myinvest.model.BrokerModel
import br.com.lambdateam.myinvest.repository.BrokerRepository
import org.springframework.stereotype.Service

@Service
class BrokerService(private val brokerRepository: BrokerRepository) {

    fun findAll() = brokerRepository.findAll()

    fun findById(id: Long): BrokerModel {
        return brokerRepository.findById(id).orElseThrow()
    }
    fun createBroker(broker: BrokerModel) {
        brokerRepository.save(broker)
    }
    fun update(broker: BrokerModel) {
        brokerRepository.save(broker)
    }
}