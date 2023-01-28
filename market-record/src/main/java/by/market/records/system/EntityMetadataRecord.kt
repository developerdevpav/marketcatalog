package by.market.records.system

import by.market.records.BaseEntityRecord
import java.util.*

class EntityMetadataRecord : BaseEntityRecord() {

    var tableName: String? = null

    var description: String? = null

    var container: UUID? = null

}
