package by.market.facade.portable

import by.market.aspect.annotation.RequestArgument
import by.market.aspect.catcher.annotation.Catcher
import by.market.domain.BaseEntity
import by.market.exception.EntityNotFoundException
import by.market.mapper.MapstructMapper
import by.market.records.BaseEntityRecord
import by.market.services.IService
import market.api.contract.IRequest
import market.api.contract.RequestPayload
import market.api.contract.ResponsePayload
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

abstract class AbstractPortableFacade<TService : IService<TEntity>, TRecord : BaseEntityRecord, TEntity : BaseEntity>
constructor(protected val entityService: TService, protected val mapper: MapstructMapper<TRecord, TEntity>) :
    PortableFacade<TRecord> {

    companion object {
        private val LOGGER: Logger = LoggerFactory.getLogger(AbstractPortableFacade.javaClass)
    }

    @Catcher
    override fun findAll(@RequestArgument request: IRequest): ResponsePayload<MutableList<TRecord>> {
        LOGGER.info("Получен запрос [получение списка]. request {}", request.id)

        val entities = entityService.findAll()

        val mutableList = mapper.toMap(entities).toMutableList()

        LOGGER.info("Обработан запрос [получение списка]. request {}", request.id)

        return ResponsePayload.of(mutableList)
    }

    @Catcher
    override fun findById(@RequestArgument request: RequestPayload<UUID>): ResponsePayload<TRecord> {
        LOGGER.info("Получен запрос [получение сущности по идентификатору]. request {}", request.payload)

        val entity = entityService.findById(request.payload)
            .map { mapper.toMap(it) }
            .orElseThrow {
                LOGGER.warn("Данные не найдены по идентификатору {}", request.payload)

                throw EntityNotFoundException(localeCode = "entity_not_found", args = arrayOf(request.payload))
            }

        LOGGER.info("Обработан запрос [получение сущности по идентификатору]. request {}", request.payload)

        return ResponsePayload.of(entity)
    }

    @Catcher
    override fun findPage(@RequestArgument request: RequestPayload<Pageable>): ResponsePayload<Page<TRecord>> {
        LOGGER.info("Получен запрос [получение страницы сущностей]. request {}", request.id)

        val page = entityService.findAll(request.payload).map { mapper.toMap(it) }

        LOGGER.info("Обработан запрос [получение страницы сущностей]. request {}", request.id)

        return ResponsePayload.of(page);
    }

}