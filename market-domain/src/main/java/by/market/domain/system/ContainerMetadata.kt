package by.market.domain.system

import by.market.domain.BaseEntity
import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "TBX_S_CONTAINER_METADATA")
class ContainerMetadata : BaseEntity() {

    @Column(name = "DESCRIPTION")
    var description: String? = null

    @Column(name = "SYSTEM_NAME")
    var systemName: String? = null

    @OneToMany(mappedBy = "container")
    @JsonBackReference("container_metadata_entities_metadata")
    var entitiesMetadata: Set<EntityMetadata>? = HashSet()

}
