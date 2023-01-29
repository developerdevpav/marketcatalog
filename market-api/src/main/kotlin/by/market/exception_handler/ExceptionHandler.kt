package by.market.exception_handler

import by.market.exception.*
import by.market.exception.i18.LocalProperties
import by.market.exception.utils.LocalizationExceptionUtils
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler
    fun handler(throwable: MarketCatalogException, request: WebRequest): ResponseEntity<ExceptionResponse> {
        val resultCode = throwable.getCode()

        return ResponseEntity
            .status(HttpStatus.OK.value())
            .body(
                ExceptionResponse(
                    LocalProperties.getMessageForLocale("code_message", resultCode.localCode, request.locale),
                    LocalizationExceptionUtils.throwDescription(request.locale, throwable),
                    resultCode.code
                )
            )
    }

    @ExceptionHandler
    fun handler(throwable: Exception, request: WebRequest): ResponseEntity<ExceptionResponse> {
        val message = LocalProperties.getMessageForLocale(
            "code_message",
            ResultCode.UNKNOWN_ERROR.localCode,
            request.locale
        )

        return ResponseEntity
            .status(HttpStatus.OK.value())
            .body(ExceptionResponse(message, throwable.message, ResultCode.UNKNOWN_ERROR.code))
    }

    data class ExceptionResponse(val message: String, val description: String?, val code: Int)

}