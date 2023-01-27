package by.market.services

import by.market.nosql.TreeUnit
import by.market.domain.units.UnitEntity

interface UnitEntityService : IService<UnitEntity> {

    fun findByValue(value: String?): UnitEntity?

    fun findUnitsTree(): MutableList<TreeUnit>

    fun findGroupUnits(): MutableList<UnitEntity>

}