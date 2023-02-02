package by.market.api.contract

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

interface IRequestPayload<T> : IRequest {

    fun getPayload(): T?

}

@JsonInclude(JsonInclude.Include.NON_NULL)
class RequestPayload<T>(
    rqId: UUID? = UUID.randomUUID(),
    private var payload: T? = null
): Request(rqId), IRequestPayload<T> {

    @JsonProperty("payload")
    override fun getPayload(): T? = payload

}
