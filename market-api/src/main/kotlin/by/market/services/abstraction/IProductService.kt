package by.market.services.abstraction

import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.domain.characteristics.single.StringCharacteristic
import by.market.domain.system.Category
import java.util.*

interface IProductService<TEntity> : IService<TEntity> {
    fun findByCategory(category: Category): List<TEntity>
    fun findDoubleCharacteristicById(id: UUID): List<DoubleCharacteristic>
    fun findStringCharacteristicById(id: UUID): List<StringCharacteristic>
}