package by.market.repository.system

import by.market.domain.system.Category
import by.market.repository.BaseRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : BaseRepository<Category> {

    fun findAllByParentCategory(category: Category): List<Category>

    fun countAllByParentCategory(category: Category): Long

    fun findAllByParentCategoryIsNull(): MutableList<Category>

}
