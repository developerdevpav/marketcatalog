package by.market.records.characteristics

import java.util.*

data class UniversalCharacteristicRecord(val id: UUID, val title: String, val dataType: String, val values: Set<String>)
