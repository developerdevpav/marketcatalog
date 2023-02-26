package by.market.facade.portable.impl

import by.market.domain.units.UnitEntity
import by.market.facade.portable.AbstractPortableFacade
import by.market.mapper.UnitEntityMapper
import by.market.records.UnitEntityRecord
import by.market.services.UnitEntityService
import org.springframework.stereotype.Service

@Service
open class PortableUnitFacade(service: UnitEntityService, mapper: UnitEntityMapper) :
    AbstractPortableFacade<UnitEntityService, UnitEntityRecord, UnitEntity>(service, mapper)