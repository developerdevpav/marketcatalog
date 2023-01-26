package by.market.domain.units

import by.market.domain.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "TBX_RB_UNIT")
class UnitEntity : BaseEntity() {

    @Column(name = "VALUE")
    var value: String? = null

    @Column(name = "DESCRIPTION")
    var description: String? = null

    @OneToMany(mappedBy = "unitGroup", fetch = FetchType.LAZY)
    var groups: MutableList<UnitEntity>? = mutableListOf()

    @ManyToOne
    @JoinColumn(name = "FK_UNIT_GROUP")
    var unitGroup: UnitEntity? = null

}