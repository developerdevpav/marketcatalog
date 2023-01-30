package by.market.exception_handler

import by.market.exception.MarketCatalogException
import by.market.exception.ResultCode
import by.market.exception.constants.BundleGroup
import by.market.exception.i18.LocalProperties
import by.market.exception.utils.LocalMessageUtils
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

        val message = LocalProperties.getMessageForLocale(
            BundleGroup.CODE_RESOURCE.value,
            resultCode.localCode,
            request.locale
        )
        val description = LocalMessageUtils.throwText(request.locale, throwable)

        return ResponseEntity
            .status(HttpStatus.OK.value())
            .body(ExceptionResponse(message, description, resultCode.code))
    }

    @ExceptionHandler
    fun handler(throwable: Exception, request: WebRequest): ResponseEntity<ExceptionResponse> {
        val localCode = ResultCode.UNKNOWN_ERROR.localCode
        val message = LocalProperties.getMessageForLocale(BundleGroup.CODE_RESOURCE.value, localCode, request.locale)

        return ResponseEntity
            .status(HttpStatus.OK.value())
            .body(ExceptionResponse(message, throwable.message, ResultCode.UNKNOWN_ERROR.code))
    }

    data class ExceptionResponse(val message: String, val description: String?, val code: Int)

}