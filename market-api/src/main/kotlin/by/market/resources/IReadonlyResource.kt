package by.market.resources

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import java.util.*

interface IReadonlyResource<TDTO> {

    fun findAll(pageable: Pageable): ResponseEntity<Page<TDTO>>

    fun findById(id: UUID): ResponseEntity<TDTO>

    fun count(): ResponseEntity<Long>

}
