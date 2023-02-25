package by.market.api.contract

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

interface IRequest {

    fun getRqId(): UUID

    fun getSourceSystem(): String

    fun getSourcePerformer(): String

}

@JsonInclude(JsonInclude.Include.NON_NULL)
open class Request(
    private var rqUid: UUID = UUID.randomUUID(),
    private var sourceSystem: String,
    private var sourcePerformer: String
) : IRequest {

    @JsonProperty("rqId")
    override fun getRqId(): UUID = rqUid

    @JsonProperty("sourceSystem")
    override fun getSourceSystem(): String = sourceSystem

    @JsonProperty("sourcePerformer")
    override fun getSourcePerformer(): String = sourcePerformer

}
