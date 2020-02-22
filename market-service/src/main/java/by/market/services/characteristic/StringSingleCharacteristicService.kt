package by.market.services.characteristic

import by.market.domain.characteristics.single.StringCharacteristic
import by.market.repository.characteristic.single.StringSingleCharacteristicRepository
import org.springframework.stereotype.Service

@Service
class StringSingleCharacteristicService(repository: StringSingleCharacteristicRepository) : BaseSingleCharacteristicService<StringCharacteristic, StringSingleCharacteristicRepository>(repository)