package pl.codesencor.foodexchangebackend.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import pl.codesencor.foodexchangebackend.user.UserRepository

@Configuration
@EnableWebSecurity
class SecurityConfig(
    userRepository: UserRepository
) : WebSecurityConfigurerAdapter() {


    @Bean
    public fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder(12);
    }

    @Bean
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }
}