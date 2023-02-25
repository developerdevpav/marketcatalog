package by.market.api.contract

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

interface IResponsePayload<T> : IResponse {

    fun getPayload(): T?

}

interface IResponsePayloadMutation<T> : IResponseMutation {

    fun setPayload(payload: T)

}

@JsonInclude(JsonInclude.Include.NON_NULL)
class ResponsePayload<T>(
    private var rqId: UUID,
    private var status: IStatus,
    private var sourceSystem: String,
    private var sourcePerformer: String,
    private var payload: T? = null
): Response(rqId, status, sourceSystem, sourcePerformer), IResponsePayload<T>, IResponsePayloadMutation<T> {

    @JsonProperty("payload")
    override fun getPayload(): T? = payload

    override fun setPayload(payload: T) {
        this.payload = payload
    }

}