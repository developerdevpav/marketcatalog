package by.market.services.impl

import by.market.domain.characteristics.Characteristic
import by.market.domain.system.DataType
import by.market.exception.DatabaseRequestInNotValidThrowable
import by.market.exception.EntityNotFoundException
import by.market.repository.characteristic.ProductCharacteristicRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class ProductCharacteristicService(
    repository: ProductCharacteristicRepository,
    private val dataTypeService: DataTypeService
) : BaseCharacteristicService<Characteristic, ProductCharacteristicRepository>(repository) {

    @Transactional
    override fun save(entity: Characteristic): Characteristic {
        val dataTypeId = entity.dataType?.id

        val title = entity.title

        if (title.isNullOrEmpty())
            throw DatabaseRequestInNotValidThrowable("Title of characteristic mustn't be is NULL or EMPTY")

        entity.title = title.trim()

        dataTypeId ?: throw DatabaseRequestInNotValidThrowable("Data type and its ID mustn't be is NULL")

        val referenceDataType: DataType? = dataTypeService.getReference(dataTypeId)

        referenceDataType ?: throw EntityNotFoundException("Data type with ID [${dataTypeId}] not found")

        val characteristicTitle: Characteristic? = repository.findByTitleAndDataType(entity.title!!, referenceDataType)

        entity.dataType = referenceDataType

        return characteristicTitle ?: super.save(entity)
    }

}
