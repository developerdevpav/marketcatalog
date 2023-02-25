package by.market.api.contract

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

interface IRequestPayload<T> : IRequest {

    fun getPayload(): T?

}

@JsonInclude(JsonInclude.Include.NON_NULL)
class RequestPayload<T>(
    private var rqId: UUID = UUID.randomUUID(),
    private var payload: T? = null,
    private var sourceSystem: String,
    private var sourcePerformer: String
) : Request(rqId, sourceSystem, sourcePerformer), IRequestPayload<T> {

    @JsonProperty("payload")
    override fun getPayload(): T? = payload

}
