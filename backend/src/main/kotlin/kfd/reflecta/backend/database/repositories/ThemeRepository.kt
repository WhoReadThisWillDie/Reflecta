package kfd.reflecta.backend.database.repositories

import kfd.reflecta.backend.database.entities.Theme
import org.springframework.data.jpa.repository.JpaRepository

interface ThemeRepository : JpaRepository<Theme, Long> {
}