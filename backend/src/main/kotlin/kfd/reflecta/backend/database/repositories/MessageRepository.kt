package kfd.reflecta.backend.database.repositories

import kfd.reflecta.backend.database.entities.Message
import org.springframework.data.jpa.repository.JpaRepository

interface MessageRepository : JpaRepository<Message, Long> {
}