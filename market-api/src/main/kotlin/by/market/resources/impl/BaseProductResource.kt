package by.market.resources.impl

import by.market.core.ProductFilter
import by.market.records.AbstractProductRecord
import by.market.records.characteristics.CharacteristicPairRecord
import by.market.records.system.CategoryRecord
import by.market.records.system.ContentPage
import by.market.facade.IProductFacade
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import java.util.*

open class BaseProductResource<TDto : AbstractProductRecord, TProductFacade : IProductFacade<TDto>>(private val productFacade: TProductFacade) :
    AbstractResource<TDto, TProductFacade>(productFacade) {

    @GetMapping("/category")
    open fun findByCategory(@RequestParam("id") category: UUID, pageable: Pageable): ResponseEntity<Page<TDto>> {
        return ResponseEntity.ok(productFacade.findByCategory(category, pageable))
    }

    @GetMapping("/categories")
    open fun findByCategories(categories: List<CategoryRecord>): ResponseEntity<List<CategoryRecord>> {
        return ResponseEntity.ok(Collections.emptyList())
    }

    @GetMapping("/characteristic")
    open fun findCharacteristic(product: TDto): ResponseEntity<CharacteristicPairRecord> {
        return ResponseEntity.ok(productFacade.findCharacteristicByProduct(product))
    }

    @PostMapping("/filter")
    open fun findByFilter(
        @RequestBody productFilter: ProductFilter,
        @RequestParam("category") id: UUID,
        pageable: Pageable
    ): ResponseEntity<ContentPage<TDto>> {
        return ResponseEntity.ok(productFacade.findByFilter(productFilter, id, pageable))
    }

}
