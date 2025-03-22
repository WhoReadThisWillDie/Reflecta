package kfd.reflecta.backend.dto

data class UserSettingsDto(
    val sendToEmail: Boolean? = null,
    val notificationFrequency: Int? = null,
    val allowStatisticsNotify: Boolean? = null,
    val cachedReportsAmount: Int? = null,
)