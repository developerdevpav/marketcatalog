package by.market.facade.portable.impl

import by.market.domain.characteristics.Characteristic
import by.market.facade.portable.AbstractPortableFacade
import by.market.mapper.ProductCharacteristicMapper
import by.market.records.characteristics.ProductCharacteristicRecord
import by.market.services.ICharacteristicService
import by.market.services.impl.ProductCharacteristicService
import org.springframework.stereotype.Service

@Service
open class PortableProductCharacteristicFacade(
    productCharacteristicService: ProductCharacteristicService,
    productCharacteristicMapper: ProductCharacteristicMapper
): AbstractPortableFacade<ICharacteristicService<Characteristic>, ProductCharacteristicRecord, Characteristic>
    (productCharacteristicService, productCharacteristicMapper)