package pl.codesencor.foodexchangebackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FoodExchangeBackendApplication

fun main(args: Array<String>) {
	runApplication<FoodExchangeBackendApplication>(*args)
}
