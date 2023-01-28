package by.market.resources.impl

import by.market.records.TreeCategoryRecord
import by.market.records.system.*
import by.market.facade.impl.CategoryProductFacade
import by.market.facade.impl.ContainerMetadataFacade
import by.market.facade.impl.DataTypeFacade
import by.market.facade.impl.EntityMetadataFacade
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/category")
class CategoryResource(facade: CategoryProductFacade) : AbstractResource<CategoryRecord, CategoryProductFacade>(facade) {

    @GetMapping("/parent/{id}")
    fun findByParent(@PathVariable("id") id: UUID): ResponseEntity<ContentPage<CategoryRecord>> =
        ResponseEntity.ok(facade.findByParent(id))

    @GetMapping("/tree")
    fun findTreeCategory(): ResponseEntity<MutableList<TreeCategoryRecord>> =
        ResponseEntity.ok(facade.findTreeCategories())

}

@RestController
@RequestMapping("/api/container-metadata")
class ContainerMetadataResource(facade: ContainerMetadataFacade) :
    AbstractResource<ContainerMetadataRecord, ContainerMetadataFacade>(facade)

@RestController
@RequestMapping("/api/data-type")
class DataTypeResource(facade: DataTypeFacade) : AbstractResource<DataTypeRecord, DataTypeFacade>(facade)

@RestController
@RequestMapping("/api/entity-metadata")
class EntityMetadataResource(service: EntityMetadataFacade) :
    AbstractResource<EntityMetadataRecord, EntityMetadataFacade>(service)

