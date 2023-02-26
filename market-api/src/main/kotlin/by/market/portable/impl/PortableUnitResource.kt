package by.market.portable.impl

import by.market.facade.portable.impl.PortableUnitFacade
import by.market.portable.AbstractPortableResource
import by.market.records.UnitEntityRecord
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/portable/units")
open class PortableUnitResource(facade: PortableUnitFacade) :
    AbstractPortableResource<UnitEntityRecord, PortableUnitFacade>(facade)
