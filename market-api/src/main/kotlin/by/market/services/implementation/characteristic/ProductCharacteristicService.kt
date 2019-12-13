package by.market.services.implementation.characteristic

import by.market.domain.characteristics.ProductCharacteristic
import by.market.repository.characteristic.ProductCharacteristicRepository
import by.market.services.implementation.BaseCharacteristicService
import org.springframework.stereotype.Service

@Service
class ProductCharacteristicService(repository: ProductCharacteristicRepository)
    : BaseCharacteristicService<ProductCharacteristic, ProductCharacteristicRepository>(repository)
