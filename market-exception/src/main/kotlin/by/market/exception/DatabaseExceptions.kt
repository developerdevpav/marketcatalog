package by.market.exception

import by.market.core.ResultCode

interface MarketCatalogThrowable {

    fun getCode(): ResultCode

    fun getLocalizationCode(): String?

    fun getArgs(): Array<Any>

}

open class ApiException(
    private val localeCode: String? = null,
    private val args: Array<Any> = arrayOf(),
    private val code: ResultCode = ResultCode.UNKNOWN_ERROR
) : RuntimeException(localeCode), MarketCatalogThrowable {

    override fun getLocalizationCode(): String? = if (localeCode.isNullOrEmpty()) code.localCode else "messages.${localeCode}"

    override fun getCode(): ResultCode = code

    override fun getArgs(): Array<Any> = args

}

open class DatabaseEntityNotFoundThrowable(
    localeCode: String? = null,
    args: Array<Any> = arrayOf(),
    code: ResultCode = ResultCode.DATA_NOT_FOUND
) : ApiException(localeCode, args, code)

open class DatabaseRequestInNotValidThrowable(
    localeCode: String? = null,
    args: Array<Any> = arrayOf(),
    code: ResultCode = ResultCode.DATA_NOT_FOUND
) : ApiException(localeCode, args, code)

open class RequestValidationException(
    localeCode: String? = null,
    args: Array<Any> = arrayOf(),
    code: ResultCode = ResultCode.REQUEST_INVALID
) : ApiException(localeCode, args, code)