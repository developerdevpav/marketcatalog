package by.market.mapper.dto.system

import by.market.mapper.dto.BaseFrontEndEntity

class EntityMetadataFrontEnd : BaseFrontEndEntity() {
    var tableName: String? = null

    var description: String? = null

    var containerFrontEnd: ContainerMetadataFrontEnd? = null
}
