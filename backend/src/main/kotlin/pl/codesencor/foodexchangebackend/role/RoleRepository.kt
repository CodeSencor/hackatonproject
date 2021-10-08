package pl.codesencor.foodexchangebackend.role

import org.springframework.data.jpa.repository.JpaRepository
import pl.codesencor.foodexchangebackend.jwt.ERole

interface RoleRepository:JpaRepository<Role, Long> {
    fun findByName(name: ERole): Role?
}