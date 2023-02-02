package by.market.api.contract

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

interface IResponsePayload<T> : IResponse {

    fun getPayload(): T?

}

@JsonInclude(JsonInclude.Include.NON_NULL)
class ResponsePayload<T>(
    rqId: UUID? = null,
    status: IStatus? = null,
    private val payload: T? = null
): Response(rqId, status), IResponsePayload<T> {

    @JsonProperty("payload")
    override fun getPayload(): T? = payload

}