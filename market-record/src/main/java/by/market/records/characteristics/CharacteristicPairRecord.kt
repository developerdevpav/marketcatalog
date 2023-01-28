package by.market.records.characteristics

data class CharacteristicPairRecord(
    val stringCharacteristicDTO: List<CharacteristicDescriptionRecord<String>>,
    val doubleCharacteristicDTO: List<CharacteristicDescriptionRecord<Double>>
)
