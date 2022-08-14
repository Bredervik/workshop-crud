package dfind.workshop.crud.domain.db

import java.math.BigInteger
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class BudgetItemEntity(
        @Id
        val id: UUID,
        val name: String,
        val value: BigInteger
)
