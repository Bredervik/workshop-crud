package dfind.workshop.crud.repository

import dfind.workshop.crud.domain.BudgetItem
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface BudgetItemRepository : CrudRepository<BudgetItem, UUID> {
}