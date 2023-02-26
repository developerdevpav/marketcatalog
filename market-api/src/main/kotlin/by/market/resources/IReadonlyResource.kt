package by.market.resources

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import java.util.*

interface IReadonlyResource<TRecord> {

    fun findAll(): ResponseEntity<MutableList<TRecord>>

    fun findPage(pageable: Pageable): ResponseEntity<Page<TRecord>>

    fun findById(id: UUID): ResponseEntity<TRecord>

}
