package by.market.records.system

import by.market.records.BaseEntityRecord
import java.util.*

class CategoryRecord : BaseEntityRecord() {

    var title: String? = null

    var systemName: String? = null

    var parent: UUID? = null

    var image: String? = null

}
