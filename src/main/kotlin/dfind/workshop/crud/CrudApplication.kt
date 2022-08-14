package dfind.workshop.crud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class CrudApplication

fun main(args: Array<String>) {
	runApplication<CrudApplication>(*args)
}
