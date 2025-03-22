package kfd.reflecta.backend.services

import jakarta.persistence.EntityNotFoundException
import kfd.reflecta.backend.database.entities.User
import kfd.reflecta.backend.database.entities.UserSettings
import kfd.reflecta.backend.dto.UserDto
import kfd.reflecta.backend.database.repositories.UserRepository
import kfd.reflecta.backend.dto.UserSettingsDto
import kfd.reflecta.backend.exceptions.BadRequestException
import kfd.reflecta.backend.exceptions.ConflictException
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun registerUser(userDto: UserDto): User {

        if (userDto.username.isNullOrBlank() || userDto.email.isNullOrBlank() ||
            userDto.password.isNullOrBlank()) {
            throw BadRequestException("All fields must be provided and cannot be empty")
        }

        if (userRepository.existsUserByUsername(userDto.username)) {
            throw ConflictException("User with this username already exists")
        }
        if (userRepository.existsUserByEmail(userDto.email)) {
            throw ConflictException("User with this email already exists")
        }

        val user = User(
            username = userDto.username,
            email = userDto.email,
            password = userDto.password
        )

        user.userSettings = UserSettings(
            user = user
        )

        return userRepository.save(user)
    }

    fun getUser(id: Long): User {
        val user = userRepository.findById(id).orElseThrow {
            EntityNotFoundException("User with id: $id not found")
        }
        return user
    }

    fun getAllUsers(): List<User> = userRepository.findAll()

    fun deleteUser(id: Long) {
        val user = getUser(id)
        userRepository.delete(user)
    }

    fun updatePassword(id: Long, newPassword: String): User {
        val user = getUser(id)

        user.password = newPassword
        return userRepository.save(user)
    }

    fun existsUserByUsername(username: String): Boolean =
        userRepository.existsUserByUsername(username)

    fun existsUserByEmail(email: String): Boolean = userRepository.existsUserByEmail(email)

    fun updateAvatar(id: Long, avatar: String): User {
        val user = getUser(id)

        user.avatar = avatar
        return userRepository.save(user)
    }

    fun updateUserSettings(id: Long, settingsDto: UserSettingsDto): User {
        val user = getUser(id)
        user.userSettings?.apply {
            settingsDto.sendToEmail?.let { sendToEmail = it }
            settingsDto.cachedReportsAmount?.let { cachedReportsAmount = it }
            settingsDto.allowStatisticsNotify?.let { allowStatisticsNotify = it }
            settingsDto.notificationFrequency?.let { notificationFrequency = it }
        }
        return userRepository.save(user)
    }

    fun getUserSettings(id: Long): UserSettings? {
        val user = getUser(id)
        return user.userSettings
    }

}