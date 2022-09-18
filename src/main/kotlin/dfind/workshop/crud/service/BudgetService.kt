package dfind.workshop.crud.service

import dfind.workshop.crud.domain.BudgetCategory
import dfind.workshop.crud.domain.BudgetItem
import dfind.workshop.crud.domain.InvalidArgumentException
import dfind.workshop.crud.domain.NotFoundException
import dfind.workshop.crud.repository.BudgetItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigInteger
import java.util.UUID

@Service
class BudgetService {

    @Autowired
    lateinit var budgetItemRepository: BudgetItemRepository

    fun getAllBudgetItems(): List<BudgetItem> {
        return budgetItemRepository.findAll().toList()
    }

    fun addItem(budgetItem: BudgetItem): BudgetItem {
        validateBudgetItem(budgetItem)
        return budgetItemRepository.save(budgetItem)
    }

    fun updateItem(id: UUID, budgetItemUpdate: BudgetItem): BudgetItem {
        validateBudgetItem(budgetItemUpdate)
        val existingItem = budgetItemRepository.findById(id).orElse(null)

        existingItem?.let {
            return budgetItemRepository.save(it.copy(name = budgetItemUpdate.name, value = budgetItemUpdate.value))
        } ?: throw NoSuchElementException("Could not find budget item with id: $id")
    }

    fun deleteItem(id: UUID) {
        budgetItemRepository.deleteById(id)
    }

    private fun validateBudgetItem(budgetItem: BudgetItem) {
        when {
            budgetItem.category == BudgetCategory.INCOME && budgetItem.value < BigInteger.ZERO -> throw IllegalArgumentException("Income cannot be negative")
            budgetItem.category != BudgetCategory.INCOME && budgetItem.value > BigInteger.ZERO -> throw IllegalArgumentException("Expenses cannot be positive")
        }
    }
}
