package kfd.reflecta.backend.database.repositories

import kfd.reflecta.backend.database.entities.Report
import org.springframework.data.jpa.repository.JpaRepository

interface ReportRepository : JpaRepository<Report, Long> {
}