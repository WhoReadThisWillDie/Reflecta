package kfd.reflecta.backend.database.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table


@Entity
@Table(name = "themes")
class Theme(
    @Column(unique = true, nullable = false)
    val name: String,

    @Column(name = "is_default")
    val isDefault: Boolean = false
) : AbstractEntity() {
}