package by.market.facade

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

interface Facade<TRecord> {

    fun findAll(): MutableList<TRecord>

    fun findAll(pageable: Pageable): Page<TRecord>

    fun findById(id: UUID): Optional<TRecord>

    fun save(entity: TRecord): TRecord

    fun delete(id: UUID): Unit

    fun delete(ids: MutableList<UUID>): Unit

}