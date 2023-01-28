package by.market.facade

import by.market.records.TreeUnitRecord
import by.market.records.UnitEntityRecord

interface UnitEntityFacade : Facade<UnitEntityRecord> {

    fun findByValue(value: String?): UnitEntityRecord

    fun findUnitsTree(): MutableList<TreeUnitRecord>

    fun findGroups(): MutableList<UnitEntityRecord>

}