package kfd.reflecta.backend.database.repositories

import kfd.reflecta.backend.database.entities.DailyStatistics
import org.springframework.data.jpa.repository.JpaRepository

interface DailyStatisticsRepository : JpaRepository<DailyStatistics, Long> {
}