package by.market.resources.system.implementation.product

import by.market.facade.product.ProductRolstorFacade
import by.market.mapper.dto.product.ProductRolstorFrontEnd
import by.market.resources.system.implementation.BaseProductResource
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/rolstor-product")
class ProductRolstorResource(facade: ProductRolstorFacade)
    : BaseProductResource<ProductRolstorFacade, ProductRolstorFrontEnd>(facade)
