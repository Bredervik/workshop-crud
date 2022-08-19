package dfind.workshop.crud.domain

import java.math.BigInteger
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class BudgetItem(
        @Id
        val id: UUID = UUID.randomUUID(),
        val name: String,
        val value: BigInteger,
        val category: BudgetCategory
)

