package by.market.api.contract

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

interface IRequest {

    fun getRqId(): UUID?

}

@JsonInclude(JsonInclude.Include.NON_NULL)
open class Request(private var rqUid: UUID? = UUID.randomUUID()): IRequest {

    @JsonProperty("rqId")
    override fun getRqId(): UUID? = rqUid

}
