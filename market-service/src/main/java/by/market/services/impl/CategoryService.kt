package by.market.services.impl

import by.market.domain.system.Category
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

    @Transactional
    override fun save(entity: Category): Category {
        entity.subCategories = mutableSetOf()

        val parentCategoryId = entity.parentCategory?.id

        entity.parentCategory = if (parentCategoryId == null)
            null
        else findById(parentCategoryId).orElseThrow {
            val message = "Parent category not found [parent = ${entity.parentCategory?.id}]"

            by.market.exception.database.EntityNotFoundException(message)
        }

        return repository.save(entity)
    }

    @Transactional(readOnly = true)
    open fun findRootCategory(idCategory: UUID): Category? {
        val category = repository.findById(idCategory)

        if (category.isEmpty) return null

        val currentCategory = category.get()
        val parentCategory = currentCategory.parentCategory

        if (parentCategory?.id == null || currentCategory.id == parentCategory.id)
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

        if (!foundOptionalCategory.isPresent) {
            return null
        }

        val treeCategory = TreeCategory()

        treeCategory.id = category.id
        treeCategory.title = category.title

        val optionalCategory = foundOptionalCategory.get()

        val subCategories: Set<Category> = optionalCategory.subCategories

        treeCategory.subcategory = subCategories.mapNotNull { buildRecursiveTree(it) }
            .toMutableList()

        return treeCategory
    }

}
