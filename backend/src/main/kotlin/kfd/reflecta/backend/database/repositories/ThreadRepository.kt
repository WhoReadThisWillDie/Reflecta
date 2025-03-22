package kfd.reflecta.backend.database.repositories

import kfd.reflecta.backend.database.entities.Thread
import org.springframework.data.jpa.repository.JpaRepository

interface ThreadRepository : JpaRepository<Thread, Long> {
}