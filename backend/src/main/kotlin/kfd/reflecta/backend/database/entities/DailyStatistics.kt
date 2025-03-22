package kfd.reflecta.backend.database.entities

import jakarta.persistence.*


@Entity
@Table(name = "daily_statistics")
class DailyStatistics(
    @Column(name = "sleep_duration")
    var sleepDuration: Int,

    @Column(name = "mood_rating", scale = 2)
    var moodRating: Double,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User,
) : AbstractEntity() {
}