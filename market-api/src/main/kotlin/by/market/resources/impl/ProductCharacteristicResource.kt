package by.market.resources.impl

import by.market.domain.characteristics.AbstractCharacteristic
import by.market.records.characteristics.AbstractCharacteristicRecord
import by.market.records.characteristics.ProductCharacteristicRecord
import by.market.facade.impl.ProductCharacteristicFacade
import by.market.facade.impl.ProductCharacteristicValueFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/product-characteristic")
class ProductCharacteristicResource(facade: ProductCharacteristicFacade) :
    AbstractResource<ProductCharacteristicRecord, ProductCharacteristicFacade>(facade) {

    @Autowired
    private lateinit var productCharacteristicValueFacade: ProductCharacteristicValueFacade

    @PostMapping("/value")
    fun saveCharacteristicValue(@RequestBody abstractCharacteristicDTO: AbstractCharacteristicRecord<Any>): ResponseEntity<AbstractCharacteristic<Any>?> {
        return ResponseEntity.ok(productCharacteristicValueFacade.save(abstractCharacteristicDTO)!!)
    }

}
