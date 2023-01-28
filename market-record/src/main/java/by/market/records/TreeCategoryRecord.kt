package by.market.records

import java.util.*

class TreeCategoryRecord {
    var id: UUID? = null
    var title: String? = null
    var subcategory: MutableList<TreeCategoryRecord> = mutableListOf()
}