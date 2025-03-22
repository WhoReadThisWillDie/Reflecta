package kfd.reflecta.backend.database.repositories

import kfd.reflecta.backend.database.entities.UserSettings
import org.springframework.data.jpa.repository.JpaRepository

interface UserSettingsRepository : JpaRepository<UserSettings, Long> {
}