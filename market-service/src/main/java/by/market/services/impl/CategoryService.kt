package by.market.services.impl

import by.market.domain.system.Category
import by.market.exception.EntityNotFoundException
import by.market.nosql.TreeCategory
import by.market.repository.system.CategoryRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
open class CategoryService(rep: CategoryRepository) :
    BaseSystemCharacteristicService<Category, CategoryRepository>(rep) {

    @Transactional(readOnly = true)
    open fun findAllByParentCategory(id: UUID): List<Category> = repository.findAllByParentCategory_Id(id)

    @Transactional(readOnly = true)
    open fun countAllByParentCategory(id: UUID): Long = repository.countAllByParentCategory_Id(id)

    @Transactional(readOnly = true)
    open fun findRootCategory(idCategory: UUID): Category? {
        val category = repository.findById(idCategory)

        if (category.isEmpty) return null

        val currentCategory = category.get()
        val parentCategory = currentCategory.parentCategory

        if (parentCategory?.id == null || category.isPresent)
            return currentCategory

        return this.findRootCategory(parentCategory.id!!)
    }

    @Transactional(readOnly = true)
    open fun findTreeCategory(): MutableList<TreeCategory> {
        val categories = repository.findAllByParentCategoryIsNull()

        return categories.mapNotNull { buildRecursiveTree(it) }.toMutableList()
    }

    private fun buildRecursiveTree(category: Category): TreeCategory? {
        val id = category.id

        id ?: return null

        val foundOptionalCategory = repository.findById(id)

        if (foundOptionalCategory.isEmpty)
            return null

        val treeCategory = TreeCategory()

        treeCategory.id = category.id
        treeCategory.title = category.title

        val optionalCategory = foundOptionalCategory.get()

        val subCategories: Set<Category> = optionalCategory.subCategories

        treeCategory.subcategory = subCategories.mapNotNull { buildRecursiveTree(it) }.toMutableList()

        return treeCategory
    }

    @Transactional
    override fun save(entity: Category): Category {
        entity.subCategories = mutableSetOf()

        entity.parentCategory = getParentCategoryOrNull(entity.parentCategory)

        return repository.save(entity)
    }

    @Throws(EntityNotFoundException::class)
    private fun getParentCategoryOrNull(category: Category?): Category? {
        val parentCategoryId = category?.id

        return if (parentCategoryId == null) null
        else findById(parentCategoryId).orElseThrow {
            EntityNotFoundException("category_parent_not_found", arrayOf(parentCategoryId))
        }
    }

}
