package by.market.api.contract

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

interface IResponse {

    fun getRqId(): UUID?

    fun getStatus(): IStatus?

}

interface IResponseMutation {

    fun setRqId(uuid: UUID?)

    fun setStatus(status: IStatus?)

}

@JsonInclude(JsonInclude.Include.NON_NULL)
open class Response(
    private var rqId: UUID? = null,
    private var status: IStatus? = null
): IResponse, IResponseMutation {

    @JsonProperty("rqId")
    override fun getRqId(): UUID? = rqId

    @JsonProperty("status")
    override fun getStatus(): IStatus? = status
    override fun setRqId(uuid: UUID?) {
        this.rqId = uuid
    }

    override fun setStatus(status: IStatus?) {
        this.status = status
    }

}