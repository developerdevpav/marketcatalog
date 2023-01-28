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
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CategoryProductFacade(
        categoryService: CategoryService,
        categoryMapper: CategoryMapper
) : BaseSystemFacade<CategoryRecord, Category, CategoryService>(categoryService, categoryMapper) {

    @Autowired
    private lateinit var treeCategoryMapper: TreeCategoryMapper

    fun findByParent(category: CategoryRecord): ContentPage<CategoryRecord> {
        val databaseCategory = mapper.fromMap(category)

        val findAllByParentCategory = entityService.findAllByParentCategory(databaseCategory)
        val length = entityService.countAllByParentCategory(databaseCategory)

        val collectionDTO = mapper.toMap(findAllByParentCategory).toMutableList()
        return ContentPage(collectionDTO, length)
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
