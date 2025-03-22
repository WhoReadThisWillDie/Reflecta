package kfd.reflecta.backend.database.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "reports")
class Report(
    @Column(nullable = false)
    val body: String,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User,
): AbstractEntity() {
}