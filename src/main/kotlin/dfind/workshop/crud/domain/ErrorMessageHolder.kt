package dfind.workshop.crud.domain

import org.springframework.http.HttpStatus
import java.time.ZonedDateTime

data class ErrorMessageHolder(
        val errorMessage: String,
        val statusCode: HttpStatus,
        val timestamp: ZonedDateTime = ZonedDateTime.now()
)
