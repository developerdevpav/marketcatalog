package by.market.facade.impl

import by.market.domain.BaseEntity
import by.market.facade.Facade
import by.market.mapper.MapstructMapper
import by.market.records.BaseEntityRecord
import by.market.services.IService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

open class AbstractFacade<TService : IService<TEntity>, TRecord : BaseEntityRecord, TEntity : BaseEntity>
    (protected val entityService: TService, protected val mapper: MapstructMapper<TRecord, TEntity>) : Facade<TRecord> {

    override fun findAll(): MutableList<TRecord> {
        val entities = entityService.findAll()

        val mutableList = mapper.toMap(entities).toMutableList()

        return mutableList
    }

    override fun findAll(pageable: Pageable): Page<TRecord> {
        val page = entityService.findAll(pageable)

        return page.map { mapper.toMap(it) }
    }

    override fun findById(id: UUID): Optional<TRecord> {
        return entityService.findById(id).map { mapper.toMap(it) }
    }

    override fun save(entity: TRecord): TRecord {
        val mappedEntity = mapper.fromMap(entity)
        val savedEntity = entityService.save(mappedEntity)
        return mapper.toMap(savedEntity)
    }

    override fun delete(id: UUID) {
        entityService.delete(id)
    }

    override fun delete(ids: MutableList<UUID>) {
        ids.forEach(this::delete)
    }

}
