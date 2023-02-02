package by.market.api.contract

import com.fasterxml.jackson.annotation.JsonInclude
import java.util.*

interface IRequestPayload<T> : IRequest {

    fun getPayload(): T?

}

@JsonInclude(JsonInclude.Include.NON_NULL)
class RequestPayload<T>(
    private var rqId: UUID? = UUID.randomUUID(),
    private var payload: T? = null
): Request(rqId), IRequestPayload<T> {

    override fun getPayload(): T? = payload

}
