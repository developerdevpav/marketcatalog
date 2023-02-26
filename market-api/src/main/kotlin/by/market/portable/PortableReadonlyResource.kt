package by.market.portable

import market.api.contract.IRequest
import market.api.contract.Request
import market.api.contract.RequestPayload
import market.api.contract.ResponsePayload
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.RequestBody
import java.util.*

interface PortableReadonlyResource<TRecord> {

    fun findAll(@RequestBody request: IRequest): ResponsePayload<MutableList<TRecord>>

    fun findById(@RequestBody request: RequestPayload<UUID>): ResponsePayload<TRecord>

    fun findPage(@RequestBody request: Request, pageable: Pageable): ResponsePayload<Page<TRecord>>

}