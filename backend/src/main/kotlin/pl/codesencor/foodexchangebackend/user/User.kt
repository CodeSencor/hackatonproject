package pl.codesencor.foodexchangebackend.user

import pl.codesencor.foodexchangebackend.role.Role
import java.util.*
import javax.persistence.*
import kotlin.collections.HashSet

@Entity(name = "user_model")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var login: String,
    var password: String,
    var name: String,
    var surName: String,

    @ManyToMany(fetch = FetchType.LAZY)
    var roles: Set<Role> = HashSet()
)