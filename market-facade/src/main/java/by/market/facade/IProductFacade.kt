package by.market.facade

import by.market.core.ProductFilter
import by.market.records.AbstractProductRecord
import by.market.records.characteristics.CharacteristicPairRecord
import by.market.records.system.ContentPage
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

interface IProductFacade<TDTO: AbstractProductRecord> : Facade<TDTO> {

    fun findByCategory(category: UUID, pageable: Pageable): Page<TDTO>

    fun findCharacteristicByProduct(product: TDTO): CharacteristicPairRecord

    fun findByFilter(productFilter: ProductFilter, category: UUID, pageable: Pageable): ContentPage<TDTO>

}
