package by.market.facade.impl

import by.market.core.ProductFilter
import by.market.domain.Product
import by.market.domain.characteristics.AbstractCharacteristic
import by.market.domain.characteristics.Characteristic
import by.market.domain.system.Category
import by.market.records.AbstractProductRecord
import by.market.records.characteristics.CharacteristicDescriptionRecord
import by.market.records.characteristics.CharacteristicPairRecord
import by.market.records.system.CategoryRecord
import by.market.records.system.ContentPage
import by.market.facade.IProductFacade
import by.market.mapper.MapstructMapper
import by.market.services.IProductService
import by.market.services.impl.CategoryService
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

open class BaseProductFacade<TDto : AbstractProductRecord, TEntity : Product>(
    entityService: IProductService<TEntity>,
    mapper: MapstructMapper<TDto, TEntity>
) : IProductFacade<TDto>, AbstractFacade<IProductService<TEntity>, TDto, TEntity>(entityService, mapper) {

    @Autowired
    private lateinit var categoryMapper: MapstructMapper<CategoryRecord, Category>

    @Autowired
    private lateinit var categoryService: CategoryService

    override fun findByCategory(category: UUID, pageable: Pageable): Page<TDto> {
        val referenceCategory = categoryService.getReference(category)

        val page = entityService.findAllByCategory(referenceCategory, pageable)

        return page.map { mapper.toMap(it) }
    }

    override fun findCharacteristicByProduct(product: TDto): CharacteristicPairRecord {
        return runBlocking {
            val doubleCharacteristicTask = async {
                buildCharacteristicMap(entityService.findDoubleCharacteristicById(product.id!!))
            }

            val stringCharacteristicTask = async {
                buildCharacteristicMap(entityService.findStringCharacteristicById(product.id!!))
            }

            val doubleRes = doubleCharacteristicTask.await()
            val stringRes = stringCharacteristicTask.await()

            CharacteristicPairRecord(
                stringRes.map {
                    CharacteristicDescriptionRecord(
                        it.key.title!!,
                        it.value.map { it.value!! }
                    )
                },
                doubleRes.map {
                    CharacteristicDescriptionRecord(
                        it.key.title!!,
                        it.value.map { it.value!! }
                    )
                }
            )
        }
    }

    private fun <TVal, TCharacteristic : AbstractCharacteristic<TVal>> buildCharacteristicMap(characteristic: List<TCharacteristic>): Map<Characteristic, MutableList<TCharacteristic>> {
        val resMap = mutableMapOf<Characteristic, MutableList<TCharacteristic>>()

        characteristic.stream()
            .forEach {
                var characteristicMetadata = resMap[it.characteristic]

                if (characteristicMetadata == null) {
                    characteristicMetadata = mutableListOf()
                    resMap[it.characteristic!!] = characteristicMetadata
                }

                characteristicMetadata.add(it)
            }

        return resMap
    }

    override fun findByFilter(productFilter: ProductFilter, category: UUID, pageable: Pageable): ContentPage<TDto> {
        val entitiesByFilter = this.entityService.findByFilter(productFilter, category, pageable)

        val recordsByFilter = entitiesByFilter.map { mapper.toMap(it) }.toMutableList()

        val countByFilter = entityService.countByFilter(productFilter, category)

        return ContentPage(recordsByFilter, countByFilter, pageable.pageNumber, pageable.pageSize)
    }

}
