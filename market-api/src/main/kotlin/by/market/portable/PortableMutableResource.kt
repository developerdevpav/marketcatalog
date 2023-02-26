package by.market.portable

import market.api.contract.RequestPayload
import market.api.contract.Response
import market.api.contract.ResponsePayload
import org.springframework.web.bind.annotation.RequestBody
import java.util.*

interface PortableMutableResource<TRecord> {

    fun save(@RequestBody request: RequestPayload<TRecord>): ResponsePayload<TRecord>

    fun delete(@RequestBody request: RequestPayload<UUID>): Response

    fun deleteList(@RequestBody request: RequestPayload<MutableList<UUID>>): Response

}