package kfd.reflecta.backend.database.entities

import jakarta.persistence.*
import kfd.reflecta.backend.enums.MessageSender

@Entity
@Table(name = "messages")
class Message(
    @Column(nullable = false)
    var text: String,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val sender: MessageSender = MessageSender.AI,

    @ManyToOne(optional = false)
    @JoinColumn(name = "thread_id")
    val thread: Thread,
) : AbstractEntity() {
}