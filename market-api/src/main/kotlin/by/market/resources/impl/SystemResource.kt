package by.market.resources.impl

import by.market.aspect.catcher.annotation.Catcher
import by.market.facade.impl.CategoryProductFacade
import by.market.facade.impl.ContainerMetadataFacade
import by.market.facade.impl.DataTypeFacade
import by.market.facade.impl.EntityMetadataFacade
import by.market.records.TreeCategoryRecord
import by.market.records.system.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/api/category")
class CategoryResource(facade: CategoryProductFacade) : AbstractResource<CategoryRecord, CategoryProductFacade>(facade) {

    @Catcher
    @GetMapping("/parent/{id}")
    fun findByParent(@PathVariable("id") id: UUID): ResponseEntity<ContentPage<CategoryRecord>> = ResponseEntity.ok(facade.findByParent(id))

    @Catcher
    @GetMapping("/tree")
    fun findTreeCategory(): ResponseEntity<MutableList<TreeCategoryRecord>> = ResponseEntity.ok(facade.findTreeCategories())

}

@RestController
@RequestMapping("/api/container-metadata")
class ContainerMetadataResource(facade: ContainerMetadataFacade) : AbstractResource<ContainerMetadataRecord, ContainerMetadataFacade>(facade)

@RestController
@RequestMapping("/api/data-type")
class DataTypeResource(facade: DataTypeFacade) : AbstractResource<DataTypeRecord, DataTypeFacade>(facade)

@RestController
@RequestMapping("/api/entity-metadata")
class EntityMetadataResource(service: EntityMetadataFacade) : AbstractResource<EntityMetadataRecord, EntityMetadataFacade>(service)

