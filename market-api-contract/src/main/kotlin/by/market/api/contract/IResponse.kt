package by.market.api.contract

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

interface IResponse {

    fun getRqId(): UUID?

    fun getSourceSystem(): String

    fun getSourcePerformer(): String

    fun getStatus(): IStatus

}

interface IResponseMutation {

    fun setRqId(uuid: UUID)

    fun setSourceSystem(sourceSystem: String)

    fun setSourcePerformer(sourcePerformer: String)

    fun setStatus(status: IStatus)

}

@JsonInclude(JsonInclude.Include.NON_NULL)
open class Response(
    private var rqId: UUID,
    private var status: IStatus,
    private var sourceSystem: String,
    private var sourcePerformer: String
) : IResponse, IResponseMutation {

    @JsonProperty("rqId")
    override fun getRqId(): UUID? = rqId

    @JsonProperty("sourceSystem")
    override fun getSourceSystem() = sourceSystem

    @JsonProperty("sourcePerformer")
    override fun getSourcePerformer(): String = sourcePerformer

    @JsonProperty("status")
    override fun getStatus(): IStatus = status

    override fun setRqId(uuid: UUID) {
        this.rqId = uuid
    }

    override fun setSourceSystem(sourceSystem: String) {
        this.sourceSystem = sourceSystem
    }

    override fun setSourcePerformer(sourcePerformer: String) {
        this.sourcePerformer = sourcePerformer
    }

    override fun setStatus(status: IStatus) {
        this.status = status
    }

}