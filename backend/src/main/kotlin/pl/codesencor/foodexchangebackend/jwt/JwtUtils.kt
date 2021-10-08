package pl.codesencor.foodexchangebackend.jwt

import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.MalformedJwtException
import io.jsonwebtoken.UnsupportedJwtException
import io.jsonwebtoken.security.Keys
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.security.SignatureException
import java.util.*
import javax.crypto.SecretKey


@Component
class JwtUtils {
    private val jwtSecret:SecretKey = Keys.hmacShaKeyFor("xbMjLaFAsTP9eoabS48goIcHSFIpigdt".toByteArray(StandardCharsets.UTF_8))
    private val parser = Jwts.parserBuilder().setSigningKey(jwtSecret).build()

    private val jwtExpirationMs = 1000 * 60 * 60 * 24 * 100L

    fun generateJwtToken(authentication: Authentication): String {
        val userPrincipal = authentication.getPrincipal() as UserDetailsImpl
        return Jwts.builder()
            .setSubject(userPrincipal.username)
            .setIssuedAt(Date())
            .setExpiration(Date(Date().getTime() + jwtExpirationMs))
            .signWith(jwtSecret)
            .compact()
    }

    fun getUserNameFromJwtToken(token: String?): String {
        return parser.parseClaimsJws(token).body.subject
    }

    fun validateJwtToken(authToken: String?): Boolean {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken)
            return true
        } catch (e: SignatureException) {
            logger.error("Invalid JWT signature: {}", e.message)
        } catch (e: MalformedJwtException) {
            logger.error("Invalid JWT token: {}", e.message)
        } catch (e: ExpiredJwtException) {
            logger.error("JWT token is expired: {}", e.message)
        } catch (e: UnsupportedJwtException) {
            logger.error("JWT token is unsupported: {}", e.message)
        } catch (e: IllegalArgumentException) {
            logger.error("JWT claims string is empty: {}", e.message)
        }
        return false
    }

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(JwtUtils::class.java)
    }
}