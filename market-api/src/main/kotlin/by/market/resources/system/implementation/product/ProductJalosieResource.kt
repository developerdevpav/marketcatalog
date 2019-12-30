package by.market.resources.system.implementation.product

import by.market.facade.product.ProductJalosieFacade
import by.market.mapper.dto.product.ProductJalosieFrontEnd
import by.market.resources.system.implementation.BaseProductResource
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/jalosie-product")
class ProductJalosieResource(facade: ProductJalosieFacade)
    : BaseProductResource<ProductJalosieFacade, ProductJalosieFrontEnd>(facade)
