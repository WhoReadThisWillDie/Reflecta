package kfd.reflecta.backend.database.repositories

import kfd.reflecta.backend.database.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface UserRepository : JpaRepository<User, Long> {
    fun existsUserByUsername(username: String): Boolean

    fun existsUserByEmail(email: String): Boolean

//    @Modifying
//    @Query("update User u set u.avatar = :avatar where u.id = :id")
//    fun updateAvatar(@Param("id") id: Long, @Param("avatar") avatar: String): User
}