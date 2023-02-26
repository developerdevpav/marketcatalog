package by.market.services

import by.market.domain.units.UnitEntity
import by.market.nosql.TreeUnit

interface UnitEntityService : IService<UnitEntity> {

    fun findByValue(value: String?): UnitEntity?

    fun findUnitsTree(): MutableList<TreeUnit>

    fun findGroupUnits(): MutableList<UnitEntity>

}