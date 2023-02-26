package by.market.facade.portable.impl

import by.market.aspect.annotation.RequestArgument
import by.market.aspect.catcher.annotation.Catcher
import by.market.domain.system.Category
import by.market.facade.portable.AbstractPortableFacade
import by.market.facade.portable.PortableCategoryProductFacade
import by.market.mapper.CategoryMapper
import by.market.mapper.TreeCategoryMapper
import by.market.records.TreeCategoryRecord
import by.market.records.system.CategoryRecord
import by.market.records.system.ContentPage
import by.market.services.impl.CategoryService
import market.api.contract.Request
import market.api.contract.RequestPayload
import market.api.contract.ResponsePayload
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
open class PortableCategoryProductFacadeImpl(service: CategoryService, mapper: CategoryMapper) :
    AbstractPortableFacade<CategoryService, CategoryRecord, Category>(service, mapper), PortableCategoryProductFacade {

    @Autowired
    private lateinit var treeCategoryMapper: TreeCategoryMapper

    @Catcher
    override fun findByParent(@RequestArgument request: RequestPayload<UUID>): ResponsePayload<ContentPage<CategoryRecord>> {
        val categories = entityService.findAllByParentCategory(request.payload)
        val length = entityService.countAllByParentCategory(request.payload)

        val categoryRecords = mapper.toMap(categories).toMutableList()

        return ResponsePayload.of(ContentPage(categoryRecords, length))
    }

    @Catcher
    override fun findTree(@RequestArgument request: Request): ResponsePayload<MutableList<TreeCategoryRecord>> {
        val treeCategory = entityService.findTreeCategory()

        val treeCategoryRecords = treeCategoryMapper.toMap(treeCategory).toMutableList()

        return ResponsePayload.of(treeCategoryRecords);
    }

}
