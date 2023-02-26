package by.market.portable.impl

import by.market.facade.portable.PortableCategoryProductFacade
import by.market.portable.AbstractPortableResource
import by.market.records.system.CategoryRecord
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/portable/category")
open class PortableCategoryProductResource(facade: PortableCategoryProductFacade)
    : AbstractPortableResource<CategoryRecord, PortableCategoryProductFacade>(facade)
