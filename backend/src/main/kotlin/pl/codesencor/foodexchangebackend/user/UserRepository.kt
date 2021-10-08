package pl.codesencor.foodexchangebackend.user

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User, UUID> {
    fun findByLogin(login: String): User?
    fun existsByLogin(login: String): Boolean
}