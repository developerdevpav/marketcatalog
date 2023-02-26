package by.market.facade.impl

import by.market.domain.system.Category
import by.market.domain.system.ContainerMetadata
import by.market.domain.system.DataType
import by.market.domain.system.EntityMetadata
import by.market.records.TreeCategoryRecord
import by.market.records.system.*
import by.market.mapper.*
import by.market.services.impl.CategoryService
import by.market.services.impl.ContainerMetadataService
import by.market.services.impl.DataTypeService
import by.market.services.impl.EntityMetadataService
import market.api.contract.RequestPayload
import market.api.contract.ResponsePayload
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class CategoryProductFacade(
        categoryService: CategoryService,
        categoryMapper: CategoryMapper
) : BaseSystemFacade<CategoryRecord, Category, CategoryService>(categoryService, categoryMapper) {

    @Autowired
    private lateinit var treeCategoryMapper: TreeCategoryMapper

    fun findByParent(id: UUID): ContentPage<CategoryRecord> {
        val categories = entityService.findAllByParentCategory(id)
        val length = entityService.countAllByParentCategory(id)

        val categoryRecords = mapper.toMap(categories).toMutableList()

        return ContentPage(categoryRecords, length)
    }

    fun findTreeCategories(): MutableList<TreeCategoryRecord> {
        return treeCategoryMapper.toMap(entityService.findTreeCategory()).toMutableList()
    }

}


@Component
class ContainerMetadataFacade(
        containerMetadataService: ContainerMetadataService,
        containerMetadataMapper: ContainerMetadataMapper
): BaseSystemFacade<ContainerMetadataRecord, ContainerMetadata, ContainerMetadataService>(containerMetadataService, containerMetadataMapper)

@Component
class EntityMetadataFacade(
        entityMetadataService: EntityMetadataService,
        entityMetadataMapper: EntityMetadataMapper
) : BaseSystemFacade<EntityMetadataRecord, EntityMetadata, EntityMetadataService>(entityMetadataService, entityMetadataMapper)

@Component
class DataTypeFacade(
        dataTypeService: DataTypeService,
        dataTypeMapper: DataTypeMapper
): BaseSystemFacade<DataTypeRecord, DataType, DataTypeService>(dataTypeService, dataTypeMapper)
