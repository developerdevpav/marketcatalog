package by.market.nosql

import java.util.*

class TreeUnit {
    var id: UUID? = null
    var value: String? = null
    var description: String? = null
    var subunits: List<TreeUnit> = mutableListOf()
}
