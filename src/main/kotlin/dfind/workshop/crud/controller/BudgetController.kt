package dfind.workshop.crud.controller

import dfind.workshop.crud.domain.BudgetItem
import dfind.workshop.crud.service.BudgetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class BudgetController {

    @Autowired
    lateinit var budgetService: BudgetService

    @GetMapping("/items")
    fun getAllBudgetItems(): List<BudgetItem> {
        return budgetService.getAllBudgetItems()
    }

    @PostMapping("/items")
    fun addBudgetItem(@RequestBody budgetItem: BudgetItem): BudgetItem {
        return budgetService.addItem(budgetItem)
    }

    @PutMapping("/items/{id}")
    fun updateBudgetItem(@PathVariable("id") id: UUID, @RequestBody budgetItem: BudgetItem): BudgetItem {
        return budgetService.updateItem(id, budgetItem)
    }

    @DeleteMapping("/items/{id}")
    fun deleteBudgetItem(@PathVariable("id") id: UUID) {
        budgetService.deleteItem(id)
    }
}