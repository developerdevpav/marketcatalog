package by.market.facade.portable

import by.market.aspect.annotation.RequestArgument
import by.market.records.TreeCategoryRecord
import by.market.records.system.CategoryRecord
import by.market.records.system.ContentPage
import market.api.contract.Request
import market.api.contract.RequestPayload
import market.api.contract.ResponsePayload
import java.util.*

/**
 *
 */
interface PortableCategoryProductFacade: PortableFacade<CategoryRecord> {

    /**
     *
     */
    fun findByParent(@RequestArgument request: RequestPayload<UUID>): ResponsePayload<ContentPage<CategoryRecord>>

    /**
     *
     */
    fun findTree(@RequestArgument request: Request): ResponsePayload<MutableList<TreeCategoryRecord>>

}