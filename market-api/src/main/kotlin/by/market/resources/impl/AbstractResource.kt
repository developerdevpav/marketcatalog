package by.market.resources.impl

import by.market.core.ResultCode
import by.market.exception.EntityNotFoundException
import by.market.exception.RequestValidationException
import by.market.facade.Facade
import by.market.resources.IReadonlyResource
import by.market.resources.MutableResource
import market.api.contract.Request
import market.api.contract.RequestPayload
import market.api.contract.ResponsePayload
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

abstract class AbstractResource<TRecord, TFacade : Facade<TRecord>>(protected val facade: TFacade) :
    MutableResource<TRecord>, IReadonlyResource<TRecord> {

    @GetMapping
    override fun findAll(): ResponseEntity<MutableList<TRecord>> = ResponseEntity.ok(facade.findAll())

    @GetMapping("/page")
    override fun findPage(pageable: Pageable): ResponseEntity<Page<TRecord>> =
        ResponseEntity.ok(facade.findAll(pageable))

    @GetMapping("/{id}")
    override fun findById(@PathVariable("id") id: UUID): ResponseEntity<TRecord> {
        val entity = facade.findById(id).orElseThrow {
            throw EntityNotFoundException("Entity not found with id [${id}]");
        }

        return ResponseEntity.ok(entity)
    }

    @PostMapping
    override fun save(@RequestBody entity: TRecord): ResponseEntity<TRecord> {
        entity ?: throw RequestValidationException(localeCode = "request_empty", code = ResultCode.REQUEST_IS_EMPTY)

        return ResponseEntity.ok(facade.save(entity))
    }

    @DeleteMapping("/{id}")
    override fun delete(@PathVariable("id") id: UUID): ResponseEntity<Unit> {
        facade.delete(id)

        return ResponseEntity.ok().build()
    }

    @DeleteMapping
    override fun deleteList(@RequestBody id: MutableList<UUID>): ResponseEntity<Unit> {
        facade.delete(id)

        return ResponseEntity.ok().build()
    }

}
