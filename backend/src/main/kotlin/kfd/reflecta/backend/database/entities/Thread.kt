package kfd.reflecta.backend.database.entities

import jakarta.persistence.*

@Entity
@Table(name = "threads")
class Thread(
    @OneToOne
    @JoinColumn(name = "note_id")
    val note: Note
) : AbstractEntity() {
    @OneToMany(
        mappedBy = "thread",
        cascade = [(CascadeType.ALL)],
        orphanRemoval = true
    )
    val messages: MutableList<Message> = mutableListOf()
}