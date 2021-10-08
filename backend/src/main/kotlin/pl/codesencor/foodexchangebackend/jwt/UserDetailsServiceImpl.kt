package pl.codesencor.foodexchangebackend.jwt

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import pl.codesencor.foodexchangebackend.user.User
import pl.codesencor.foodexchangebackend.user.UserRepository
import javax.transaction.Transactional

@Service
class UserDetailsServiceImpl(private val userRepository: UserRepository) : UserDetailsService {

    @Transactional
    override fun loadUserByUsername(username: String): UserDetails {
        val user: User = userRepository.findByLogin(username)
            ?: throw UsernameNotFoundException("User Not Found with username: $username")
        return UserDetailsImpl.build(user)
    }
}