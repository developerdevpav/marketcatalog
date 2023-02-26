package by.market.repository.system

import by.market.domain.system.Category
import by.market.repository.BaseRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CategoryRepository : BaseRepository<Category> {

    fun findAllByParentCategory_Id(id: UUID): List<Category>

    fun countAllByParentCategory_Id(id: UUID): Long

    fun findAllByParentCategoryIsNull(): MutableList<Category>

}
