package by.market.facade.impl

import by.market.domain.units.UnitEntity
import by.market.records.TreeUnitRecord
import by.market.records.UnitEntityRecord
import by.market.exception.DatabaseEntityNotFoundThrowable
import by.market.exception.DatabaseRequestInNotValidThrowable
import by.market.facade.UnitEntityFacade
import by.market.mapper.UnitEntityMapper
import by.market.mapper.UnitEntityTreeMapper
import by.market.services.UnitEntityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class UnitEntityFacadeImpl(service: UnitEntityService, mapper: UnitEntityMapper)
    : AbstractFacade<UnitEntityService, UnitEntityRecord, UnitEntity>(service, mapper), UnitEntityFacade {

    @Autowired
    private lateinit var unitEntityTreeMapper: UnitEntityTreeMapper


    override fun findByValue(value: String?): UnitEntityRecord {
        value ?: throw DatabaseRequestInNotValidThrowable("Value mustn't is NULL")

        val unitEntity: UnitEntity? = entityService.findByValue(value)

        unitEntity ?: throw DatabaseEntityNotFoundThrowable("Entity not found by value [$value]")

        return mapper.toMap(unitEntity)
    }

    override fun findUnitsTree(): MutableList<TreeUnitRecord> {
        val unitsTree = entityService.findUnitsTree()

        return unitEntityTreeMapper.toMap(unitsTree).toMutableList()
    }

    override fun findGroups(): MutableList<UnitEntityRecord> {
        val findGroupUnits = entityService.findGroupUnits()
        return mapper.toMap(findGroupUnits).toMutableList()
    }

}