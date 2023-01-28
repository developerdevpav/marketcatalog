package by.market.facade.impl

import by.market.domain.characteristics.AbstractCharacteristic
import by.market.records.characteristics.AbstractCharacteristicRecord
import by.market.mapper.CharacteristicValueMapper
import by.market.services.impl.ProductValueService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ProductCharacteristicValueFacade(private val productValueService: ProductValueService) {

    @Autowired
    private lateinit var characteristicValueMapper: CharacteristicValueMapper

    fun save(entity: AbstractCharacteristicRecord<Any>): AbstractCharacteristic<Any>? {
        val abstractCharacteristic = characteristicValueMapper.fromMap(entity)
        return productValueService.save(abstractCharacteristic)
    }

}
