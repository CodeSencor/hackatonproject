package pl.codesencor.foodexchangebackend.util

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import pl.codesencor.foodexchangebackend.jwt.ERole
import pl.codesencor.foodexchangebackend.role.Role
import pl.codesencor.foodexchangebackend.role.RoleRepository
import pl.codesencor.foodexchangebackend.user.User
import pl.codesencor.foodexchangebackend.user.UserRepository


@Component
class DataLoader(
    private val roleRepository: RoleRepository
) : ApplicationRunner {
    override fun run(args: ApplicationArguments) {
        roleRepository.save<Role>(Role(name = ERole.ROLE_USER))
    }
}