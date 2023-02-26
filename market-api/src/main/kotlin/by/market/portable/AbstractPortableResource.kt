package by.market.portable

import by.market.facade.portable.PortableFacade
import market.api.contract.IRequest
import market.api.contract.Request
import market.api.contract.RequestPayload
import market.api.contract.ResponsePayload
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import java.util.*

abstract class AbstractPortableResource<TRecord, TPortableFacade : PortableFacade<TRecord>>(protected val portableFacade: TPortableFacade) :
    PortableReadonlyResource<TRecord> {

    @PostMapping("/findAll")
    override fun findAll(@RequestBody request: IRequest): ResponsePayload<MutableList<TRecord>> =
        portableFacade.findAll(request)

    @PostMapping("/findById")
    override fun findById(@RequestBody request: RequestPayload<UUID>): ResponsePayload<TRecord> =
        portableFacade.findById(request)

    @PostMapping("/findPage")
    override fun findPage(@RequestBody request: Request, pageable: Pageable): ResponsePayload<Page<TRecord>> =
        portableFacade.findPage(RequestPayload.of(request, pageable))

}
