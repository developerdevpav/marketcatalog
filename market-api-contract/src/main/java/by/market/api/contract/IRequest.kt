package by.market.api.contract

import by.market.core.Locale
import com.fasterxml.jackson.annotation.JsonInclude
import java.util.UUID

interface IRequest {

    fun getRqId(): UUID?

    fun getLocal(): Locale?

}

@JsonInclude(JsonInclude.Include.NON_NULL)
open class Request(
    private var rqUid: UUID? = UUID.randomUUID(),
    private var locale: Locale? = Locale.RU): IRequest {

    override fun getRqId(): UUID? = rqUid

    override fun getLocal(): Locale? = locale

}
