package br.com.lambdateam.myinvest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MyinvestApplication

fun main(args: Array<String>) {
	runApplication<MyinvestApplication>(*args)
}
