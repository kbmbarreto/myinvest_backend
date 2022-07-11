package br.com.lambdateam.myinvest.controller

import br.com.lambdateam.myinvest.extension.toBrokerModel
import br.com.lambdateam.myinvest.extension.toModel
import br.com.lambdateam.myinvest.extension.toResponse
import br.com.lambdateam.myinvest.model.response.BrokerResponse
import br.com.lambdateam.myinvest.model.response.PostBroker
import br.com.lambdateam.myinvest.model.response.PutBroker
import br.com.lambdateam.myinvest.repository.BrokerRepository
import br.com.lambdateam.myinvest.service.BrokerService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@Service
@RestController
@RequestMapping("brokers", produces = [MediaType.APPLICATION_JSON_VALUE])
class BrokerController(val brokerService: BrokerService, val brokerRepository: BrokerRepository) {

    @GetMapping
    fun listBrokers() = brokerService.findAll().map { it.toResponse() }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): BrokerResponse {
        return brokerService.findById(id).toResponse()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createBroker(@RequestBody broker: PostBroker) {
        brokerService.createBroker(broker.toModel())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun fullUpdateBroker(@PathVariable id: Long, @RequestBody broker: PutBroker) {
        val brokerSaved = brokerService.findById(id)
        brokerService.update(broker.toBrokerModel(brokerSaved))
    }
}