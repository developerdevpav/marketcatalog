package by.market.services.impl

import by.market.domain.BaseEntity
import by.market.repository.BaseRepository
import by.market.services.IService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

open class BaseService<TEntity: BaseEntity, TRepository: BaseRepository<TEntity>>(protected val repository: TRepository) : IService<TEntity> {

    override fun findAll(): MutableList<TEntity> = repository.findAll()

    override fun findAll(pageable: Pageable): Page<TEntity> = repository.findAll(pageable)

    override fun findById(id: UUID): Optional<TEntity> = repository.findById(id)

    override fun getReference(id: UUID): TEntity? =
        try {
            repository.getReferenceById(id)
        } catch (ex: Exception) {
            null
        }

    override fun save(entity: TEntity): TEntity = repository.save(entity)

    override fun delete(id: UUID): Unit = repository.deleteById(id)

    override fun delete(ids: MutableList<UUID>) {
        ids.forEach(this::delete)
    }

}
