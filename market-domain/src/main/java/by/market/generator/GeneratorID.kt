package by.market.generator

import by.market.domain.BaseEntity
import org.hibernate.HibernateException
import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.hibernate.id.UUIDGenerator
import java.util.*

class GeneratorID : UUIDGenerator() {

    @Throws(HibernateException::class)
    override fun generate(session: SharedSessionContractImplementor, obj: Any): Any? {
        if (Objects.isNull(obj)) {
            throw HibernateException(NullPointerException())
        }
        return if (Objects.isNull((obj as BaseEntity).id)) super.generate(session, obj) else obj.id!!
    }

}
