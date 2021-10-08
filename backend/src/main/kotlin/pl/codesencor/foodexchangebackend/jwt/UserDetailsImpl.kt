package pl.codesencor.foodexchangebackend.jwt

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import pl.codesencor.foodexchangebackend.user.User
import java.util.*
import java.util.stream.Collectors


class UserDetailsImpl(
    private val id: Long,
    private val username: String,
    private val password: String,
    private val authorities: Collection<GrantedAuthority>
) : UserDetails {

    companion object {
        fun build(user: User): UserDetailsImpl {
            val authorities: List<GrantedAuthority> = user.roles.stream()
                .map { role -> SimpleGrantedAuthority(role.name.name) }
                .collect(Collectors.toList())

            return UserDetailsImpl(
                user.id,
                user.login,
                user.password,
                authorities
            )
        }
    }

    override fun getAuthorities() = authorities

    override fun getPassword() = password

    override fun getUsername() = username

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}