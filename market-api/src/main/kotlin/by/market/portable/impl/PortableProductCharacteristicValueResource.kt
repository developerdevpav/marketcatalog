package by.market.portable.impl

import by.market.facade.portable.AbstractPortableFacade
import by.market.facade.portable.impl.PortableProductCharacteristicFacade
import by.market.portable.AbstractPortableResource
import by.market.records.characteristics.ProductCharacteristicRecord
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/portable/product-characteristic")
class PortableProductCharacteristicValueResource(facade: PortableProductCharacteristicFacade)
    : AbstractPortableResource<ProductCharacteristicRecord, PortableProductCharacteristicFacade>(facade)
