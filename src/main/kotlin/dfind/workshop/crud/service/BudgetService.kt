package dfind.workshop.crud.service

import dfind.workshop.crud.domain.db.BudgetItemEntity
import dfind.workshop.crud.domain.dto.BudgetItem
import dfind.workshop.crud.repository.BudgetItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class BudgetService {

    @Autowired
    lateinit var budgetItemRepository: BudgetItemRepository

    fun getAllBudgetItems(): List<BudgetItem> {
        return budgetItemRepository.findAll().map { mapEntityToDto(it) }
    }

    fun addItem(budgetItem: BudgetItem): BudgetItem {
        val entity = budgetItemRepository.save(mapDtoToEntity(budgetItem))

        return mapEntityToDto(entity)
    }


    private fun mapEntityToDto(entity: BudgetItemEntity): BudgetItem {
        return BudgetItem(
                name = entity.name,
                value = entity.value
        )
    }

    private fun mapDtoToEntity(dto: BudgetItem): BudgetItemEntity {
        return BudgetItemEntity(
                id = UUID.randomUUID(),
                name = dto.name,
                value = dto.value
        )
    }
}
