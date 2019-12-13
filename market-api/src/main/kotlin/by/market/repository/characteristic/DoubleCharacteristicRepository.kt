package by.market.repository.characteristic

import by.market.domain.characteristics.DoubleCharacteristic
import by.market.repository.AbstractCharacteristicRepository
import org.springframework.stereotype.Repository

@Repository
interface DoubleCharacteristicRepository : AbstractCharacteristicRepository<DoubleCharacteristic, Double>
