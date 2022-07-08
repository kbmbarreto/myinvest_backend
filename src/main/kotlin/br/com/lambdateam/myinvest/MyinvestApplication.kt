package br.com.lambdateam.myinvest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*
import javax.annotation.PostConstruct

@SpringBootApplication
class MyinvestApplication

fun main(args: Array<String>) {
	runApplication<MyinvestApplication>(*args)
}

@PostConstruct
fun init() {
	TimeZone.setDefault(TimeZone.getTimeZone("UTC-3:00"))
}