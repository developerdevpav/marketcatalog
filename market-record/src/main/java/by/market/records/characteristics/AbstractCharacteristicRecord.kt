package by.market.records.characteristics

import by.market.records.BaseEntityRecord
import java.util.*

open class AbstractCharacteristicRecord<T> : BaseEntityRecord() {

    var value: T? = null

    var characteristic: UUID? = null

    var product: UUID? = null

}
