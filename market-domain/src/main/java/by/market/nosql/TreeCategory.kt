package by.market.nosql

import java.util.*

class TreeCategory {

    var id: UUID? = null
    var title: String? = null
    var subcategory: MutableList<TreeCategory> = mutableListOf()

}