package pl.codesencor.foodexchangebackend.user

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import pl.codesencor.foodexchangebackend.user.request.LoginRequest

@RestController
@RequestMapping("/api/v1/user")
class UserController(private val userRepository: UserRepository) {

    @PostMapping("register")
    fun registerUser() {

    }

    @PostMapping("login")
    fun loginUser(@RequestBody loginRequest: LoginRequest) {

    }

}