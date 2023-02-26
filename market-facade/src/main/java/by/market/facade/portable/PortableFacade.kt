package by.market.facade.portable

import by.market.aspect.annotation.RequestArgument
import by.market.aspect.catcher.annotation.Catcher
import by.market.exception.EntityNotFoundException
import market.api.contract.IRequest
import market.api.contract.RequestPayload
import market.api.contract.ResponsePayload
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

/**
 * The portable facade presents an interface for intelligent processing of a user request
 *
 * @author Talaika Pavel
 */
interface PortableFacade<TRecord> {

    /**
     * Method for getting a list of entities by portable request
     *
     * @param request the portable request
     * @return the response with list entities
     */
    @Catcher
    fun findAll(@RequestArgument request: IRequest): ResponsePayload<MutableList<TRecord>>

    /**
     * Method for getting an entity by id by portable request
     *
     * @param request the portable request with entity id
     * @return the response with entity
     *
     * @exception EntityNotFoundException exception when entity not found
     */
    @Catcher
    fun findById(@RequestArgument request: RequestPayload<UUID>): ResponsePayload<TRecord>

    /**
     * Method for getting a page entities by pageable
     *
     * @param request the portable request with pageable data
     * @return the response with page entities
     */
    @Catcher
    fun findPage(@RequestArgument request: RequestPayload<Pageable>): ResponsePayload<Page<TRecord>>

}