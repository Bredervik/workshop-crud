package dfind.workshop.crud.config

import dfind.workshop.crud.domain.ErrorMessageHolder
import org.springframework.beans.TypeMismatchException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@ControllerAdvice
class ErrorHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFoundException(ex: NoSuchElementException, request: WebRequest): ResponseEntity<Any> {
        return handleExceptionInternal(ex, ErrorMessageHolder(ex.localizedMessage, HttpStatus.NOT_FOUND), HttpHeaders(), HttpStatus.NOT_FOUND, request)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(ex: IllegalArgumentException, request: WebRequest): ResponseEntity<Any> {
        return handleExceptionInternal(ex, ErrorMessageHolder(ex.localizedMessage, HttpStatus.BAD_REQUEST), HttpHeaders(), HttpStatus.BAD_REQUEST, request)
    }

    override fun handleHttpMessageNotReadable(ex: HttpMessageNotReadableException, headers: HttpHeaders, status: HttpStatus, request: WebRequest): ResponseEntity<Any> {
        return handleExceptionInternal(ex, ErrorMessageHolder(ex.localizedMessage, HttpStatus.BAD_REQUEST), HttpHeaders(), HttpStatus.BAD_REQUEST, request)
    }

    override fun handleTypeMismatch(ex: TypeMismatchException, headers: HttpHeaders, status: HttpStatus, request: WebRequest): ResponseEntity<Any> {
        return handleExceptionInternal(ex, ErrorMessageHolder(ex.localizedMessage, HttpStatus.BAD_REQUEST), HttpHeaders(), HttpStatus.BAD_REQUEST, request)
    }
}
