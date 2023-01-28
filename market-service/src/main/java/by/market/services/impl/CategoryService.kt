package by.market.services.impl

import by.market.nosql.TreeCategory
import by.market.domain.system.Category
import by.market.repository.system.CategoryRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
open class CategoryService(private val rep: CategoryRepository) : BaseSystemCharacteristicService<Category, CategoryRepository>(rep) {

    fun findAllByParentCategory(category: Category): List<Category> = rep.findAllByParentCategory(category)

    fun countAllByParentCategory(category: Category): Long = rep.countAllByParentCategory(category)

    @Transactional
    override fun save(entity: Category): Category {
        entity.subCategories = mutableSetOf()

        val parentCategory = entity.parentCategory

        if (parentCategory !== null) {
            entity.parentCategory =
                    if (parentCategory.id == null) null else rep.getReferenceById(parentCategory.id!!)
        }

        return rep.save(entity)
    }

    fun findRootCategory(idCategory: UUID): Category? {
        val category = rep.findById(idCategory)

        if (category.isEmpty) return null

        val currentCategory = category.get()
        val parentCategory = currentCategory.parentCategory

        if (parentCategory?.id == null || currentCategory.id == parentCategory.id)
            return currentCategory

        return this.findRootCategory(parentCategory.id!!)
    }

    @Transactional(readOnly = true)
    open fun findTreeCategory(): MutableList<TreeCategory> {
        val categories = rep.findAllByParentCategoryIsNull();
        return categories.mapNotNull { buildRecursiveTree(it) }.toMutableList()
    }

    private fun buildRecursiveTree(category: Category): TreeCategory? {
        val id = category.id

        id ?: return null

        val foundOptionalCategory = rep.findById(id)

        if (!foundOptionalCategory.isPresent) {
            return null
        }

        val treeCategory = TreeCategory()

        treeCategory.id = category.id
        treeCategory.title = category.title

        val optionalCategory = foundOptionalCategory.get()

        val subCategories: Set<Category> = optionalCategory.subCategories

        val setSubCategories = subCategories

        treeCategory.subcategory = setSubCategories.mapNotNull { buildRecursiveTree(it) }
                .toMutableList()

        return treeCategory
    }

}
