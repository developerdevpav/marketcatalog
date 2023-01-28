package by.market.resources.impl

import by.market.records.TreeUnitRecord
import by.market.records.UnitEntityRecord
import by.market.facade.UnitEntityFacade
import by.market.resources.UnitEntityResource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/units")
class UnitEntityResourceImpl(facade: UnitEntityFacade)
    : AbstractResource<UnitEntityRecord, UnitEntityFacade>(facade), UnitEntityResource {

    @GetMapping("/value")
    override fun findByValue(@RequestParam("value") value: String?): ResponseEntity<UnitEntityRecord> =
        ResponseEntity.ok(facade.findByValue(value))

    @GetMapping("/tree")
    override fun findUnitsTree(): ResponseEntity<MutableList<TreeUnitRecord>> =
        ResponseEntity.ok(facade.findUnitsTree())

    @GetMapping("/groups")
    override fun findGroups(): ResponseEntity<MutableList<UnitEntityRecord>> =
        ResponseEntity.ok(facade.findGroups())

}
