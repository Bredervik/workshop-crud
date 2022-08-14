package dfind.workshop.crud.repository

import dfind.workshop.crud.domain.db.BudgetItemEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface BudgetItemRepository : CrudRepository<BudgetItemEntity, UUID> {
}