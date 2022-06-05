package by.market.repository.characteristic

import by.market.domain.Product
import by.market.domain.characteristics.AbstractCharacteristic
import by.market.domain.system.EntityMetadata
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface AbstractSingleCharacteristicRepository<TEntity: AbstractCharacteristic<TEntityValue>, TEntityValue> : AbstractCharacteristicRepository<TEntity, TEntityValue> {

    fun findByEntityMetadataAndProduct(metadata: EntityMetadata, product: Product?): List<TEntity>

}
