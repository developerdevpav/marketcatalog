package by.market.records

import java.util.*


open class AbstractProductRecord : BaseEntityRecord() {

    var priceValue: Int? = null

    var title: String? = null

    var image: String? = null

    var category: UUID? = null

}
