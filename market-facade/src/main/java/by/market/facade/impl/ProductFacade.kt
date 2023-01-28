package by.market.facade.impl

import by.market.domain.Product
import by.market.records.product.ProductRecord
import by.market.mapper.ProductMapper
import by.market.services.impl.ProductService
import org.springframework.stereotype.Component

@Component
class ProductFacade (productService: ProductService, productMapper: ProductMapper)
    : BaseProductFacade<ProductRecord, Product>(productService, productMapper)
