package by.market.resources

import by.market.records.TreeUnitRecord
import by.market.records.UnitEntityRecord
import org.springframework.http.ResponseEntity

interface UnitEntityResource : MutableResource<UnitEntityRecord>, IReadonlyResource<UnitEntityRecord> {

    fun findByValue(value: String?): ResponseEntity<UnitEntityRecord>

    fun findUnitsTree(): ResponseEntity<MutableList<TreeUnitRecord>>

    fun findGroups(): ResponseEntity<MutableList<UnitEntityRecord>>

}