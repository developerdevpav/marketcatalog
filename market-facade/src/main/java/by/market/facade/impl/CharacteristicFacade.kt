package by.market.facade.impl

import by.market.domain.characteristics.Characteristic
import by.market.mapper.ProductCharacteristicMapper
import by.market.records.characteristics.ProductCharacteristicRecord
import by.market.services.ICharacteristicService
import by.market.services.impl.ProductCharacteristicService
import org.springframework.stereotype.Component

@Component
class ProductCharacteristicFacade(
    productCharacteristicService: ProductCharacteristicService,
    productCharacteristicMapper: ProductCharacteristicMapper
) : AbstractFacade<ICharacteristicService<Characteristic>, ProductCharacteristicRecord, Characteristic>
    (productCharacteristicService, productCharacteristicMapper)
