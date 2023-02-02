package by.market.api.contract

import com.fasterxml.jackson.annotation.JsonInclude
import java.util.UUID

interface IRequest {

    fun getRqId(): UUID?

}

@JsonInclude(JsonInclude.Include.NON_NULL)
open class Request(private var rqUid: UUID? = UUID.randomUUID()): IRequest {

    override fun getRqId(): UUID? = rqUid

}
