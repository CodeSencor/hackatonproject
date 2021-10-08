package pl.codesencor.foodexchangebackend.user

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user")
class UserController(private val userRepository: UserRepository) {

}