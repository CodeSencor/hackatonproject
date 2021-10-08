package pl.codesencor.foodexchangebackend.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import pl.codesencor.foodexchangebackend.jwt.*
import pl.codesencor.foodexchangebackend.user.UserRepository


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
    prePostEnabled = true
)
class SecurityConfig(
    private val userRepository: UserRepository,
    private val unauthorizedHandler: AuthEntryPointJwt,
    private val jwtUtils: JwtUtils,
    private val userDetailsServiceImpl: UserDetailsServiceImpl
) : WebSecurityConfigurerAdapter() {


    @Bean
    public fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder(12);
    }

    @Bean
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }

    @Bean
    fun authTokenFilter():AuthTokenFilter{
        return AuthTokenFilter(jwtUtils, userDetailsServiceImpl)
    }

    override fun configure(http: HttpSecurity) {
        http.cors().and().csrf().disable()
            .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .authorizeRequests().antMatchers("/api/auth/**").permitAll()
            .antMatchers("/api/test/**").permitAll()
            .anyRequest().authenticated();

        http.addFilterBefore(authTokenFilter(), UsernamePasswordAuthenticationFilter::class.java);
    }
}