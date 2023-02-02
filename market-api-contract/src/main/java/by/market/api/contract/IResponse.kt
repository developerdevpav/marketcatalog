package by.market.api.contract

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

interface IResponse {

    fun getRqId(): UUID?

    fun getStatus(): IStatus?

}

@JsonInclude(JsonInclude.Include.NON_NULL)
open class Response(
    private var rqId: UUID? = null,
    private var status: IStatus? = null
): IResponse {

    @JsonProperty("rqId")
    override fun getRqId(): UUID? = rqId

    @JsonProperty("status")
    override fun getStatus(): IStatus? = status

}