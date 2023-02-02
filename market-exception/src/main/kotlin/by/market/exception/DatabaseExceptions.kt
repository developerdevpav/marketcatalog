package by.market.exception

import by.market.core.ResultCode

interface MarketCatalogThrowable {

    fun getDescription(): String?

    fun getCode(): ResultCode

    fun getArgs(): Array<Any>

    fun isLocalization(): Boolean {
        return false
    }

}

open class ApiException(
    private val description: String? = null,
    private val localization: Boolean = false,
    private val args: Array<Any> = arrayOf(),
    private val code: ResultCode = ResultCode.DATA_NOT_FOUND,
) : RuntimeException(description), MarketCatalogThrowable {

    override fun isLocalization(): Boolean = localization

    override fun getDescription(): String? = "messages.${description}"

    override fun getCode(): ResultCode = code

    override fun getArgs(): Array<Any> = args

}

open class DatabaseEntityNotFoundThrowable(
    description: String? = null,
    localization: Boolean = false,
    args: Array<Any> = arrayOf(),
    code: ResultCode = ResultCode.DATA_NOT_FOUND,
) : ApiException(description, localization, args, code)

open class DatabaseRequestInNotValidThrowable(
    description: String? = null,
    localization: Boolean = false,
    args: Array<Any> = arrayOf(),
    code: ResultCode = ResultCode.DATA_NOT_FOUND,
) : ApiException(description, localization, args, code)
