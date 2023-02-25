package by.market.api.contract

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

interface IStatus {

    fun getCode(): Int

    fun getMessage(): String

    fun getDetails(): String?

}

@JsonInclude(JsonInclude.Include.NON_NULL)
class Status(
    private val code: Int,
    private val message: String,
    private var details: String? = null
): IStatus {

    @JsonProperty("code")
    override fun getCode(): Int = code

    @JsonProperty("message")
    override fun getMessage(): String = message

    @JsonProperty("details")
    override fun getDetails(): String? = details

}