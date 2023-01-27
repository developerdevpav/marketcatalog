package by.market.domain

import by.market.converters.DeserializerUUID
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.GenericGenerator
import java.util.*

@MappedSuperclass
open class BaseEntity {

    @Id
    @GenericGenerator(name = "useIdOrGenerate", strategy = "by.market.generator.GeneratorID")
    @GeneratedValue(generator = "useIdOrGenerate")
    @Column(name = "id", nullable = false, unique = true)
    @JsonDeserialize(using = DeserializerUUID::class)
    open var id: UUID? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BaseEntity) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

}
