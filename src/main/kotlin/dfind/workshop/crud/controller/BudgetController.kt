package dfind.workshop.crud.controller

import dfind.workshop.crud.domain.dto.BudgetItem
import dfind.workshop.crud.service.BudgetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

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
}
