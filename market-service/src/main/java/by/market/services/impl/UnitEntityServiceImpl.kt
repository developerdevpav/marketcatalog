package by.market.services.impl

import by.market.domain.units.UnitEntity
import by.market.nosql.TreeUnit
import by.market.repository.UnitEntityRepository
import by.market.services.UnitEntityService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class UnitEntityServiceImpl(unitEntityRepository: UnitEntityRepository) : BaseService<UnitEntity,
        UnitEntityRepository>(unitEntityRepository), UnitEntityService {

    override fun findByValue(value: String?): UnitEntity? = repository.findByValue(value)

    @Transactional(readOnly = true)
    override fun findUnitsTree(): MutableList<TreeUnit> {
        val rootGroups: MutableList<UnitEntity>? = repository.findByUnitGroupIsNull()

        return if (rootGroups.isNullOrEmpty())
            mutableListOf()
        else
            rootGroups.mapNotNull { getRecursionTree(it) }.toMutableList()
    }

    override fun findGroupUnits(): MutableList<UnitEntity> {
        return repository.findByUnitGroupIsNull() ?: mutableListOf()
    }

    private fun getRecursionTree(treeUnit: UnitEntity): TreeUnit? {
        val unitEntity = repository.findById(treeUnit.id!!)

        if (unitEntity.isPresent) {
            val treeUnitObject = TreeUnit()

            treeUnitObject.description = treeUnit.description
            treeUnitObject.value = treeUnit.value
            treeUnitObject.id = treeUnit.id

            val groups = treeUnit.groups

            treeUnitObject.subunits = if (groups.isNullOrEmpty())
                mutableListOf()
            else
                groups.mapNotNull { getRecursionTree(it) }.toMutableList()

            return treeUnitObject
        }

        return null
    }


}
