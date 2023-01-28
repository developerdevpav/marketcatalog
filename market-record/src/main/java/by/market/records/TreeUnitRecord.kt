package by.market.records

import java.util.*

class TreeUnitRecord {

    var id: UUID? = null

    var value: String? = null

    var description: String? = null

    var subunits: List<TreeUnitRecord> = mutableListOf()

}