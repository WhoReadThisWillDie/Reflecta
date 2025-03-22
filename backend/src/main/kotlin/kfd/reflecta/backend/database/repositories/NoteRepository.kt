package kfd.reflecta.backend.database.repositories

import kfd.reflecta.backend.database.entities.Note
import org.springframework.data.jpa.repository.JpaRepository

interface NoteRepository : JpaRepository<Note, Long> {
}