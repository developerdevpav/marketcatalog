package by.market.mapper.dto.characteristics

import by.market.mapper.dto.BaseFrontEndEntity
import by.market.mapper.dto.system.EntityMetadataFrontEnd

abstract class AbstractFrontEndCharacteristic<T> : BaseFrontEndEntity() {

    var value: T? = null

    var productCharacteristic: ProductFrontEndCharacteristic? = null

    var entityMetadata: EntityMetadataFrontEnd? = null
}