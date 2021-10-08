package pl.codesencor.foodexchangebackend.jwt

import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*
import pl.codesencor.foodexchangebackend.jwt.request.LoginRequest
import pl.codesencor.foodexchangebackend.jwt.request.RegisterRequest
import pl.codesencor.foodexchangebackend.jwt.response.JwtResponse
import pl.codesencor.foodexchangebackend.response.MessageResponse
import pl.codesencor.foodexchangebackend.role.Role
import pl.codesencor.foodexchangebackend.role.RoleRepository
import pl.codesencor.foodexchangebackend.user.User
import pl.codesencor.foodexchangebackend.user.UserRepository


@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
class JwtAuthenticationController(
    private val authenticationManager: AuthenticationManager,
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtUtils: JwtUtils
) {

    @PostMapping("register")
    fun registerUser(@RequestBody registerRequest: RegisterRequest): ResponseEntity<Any>  {

        if (userRepository.existsByLogin(registerRequest.login)) {
            return ResponseEntity
                .badRequest()
                .body<Any>(MessageResponse("Error: Email is already in use!"))
        }

        val roles: MutableSet<Role> = HashSet<Role>()

        val userRole: Role = roleRepository.findByName(ERole.ROLE_USER)?:
        throw RuntimeException("Error: Role is not found.")
        roles.add(userRole)

        val user = User(
            login = registerRequest.login,
            password = passwordEncoder.encode(registerRequest.password),
            name = registerRequest.name,
            surName = registerRequest.surname,
            roles = roles
        )

        userRepository.save<User>(user)

        return ResponseEntity.ok<Any>(MessageResponse("User registered successfully!"))
    }

    @PostMapping("login")
    fun loginUser(@RequestBody loginRequest: LoginRequest): ResponseEntity<JwtResponse> {

        val authentication: Authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(loginRequest.login, loginRequest.password)
        )

        SecurityContextHolder.getContext().authentication = authentication
        val jwt = jwtUtils.generateJwtToken(authentication)

        return ResponseEntity.ok<JwtResponse>(
            JwtResponse(
                jwt
            )
        )
    }

}