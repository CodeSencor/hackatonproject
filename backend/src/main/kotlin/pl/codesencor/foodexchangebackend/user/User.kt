package pl.codesencor.foodexchangebackend.user

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class User(
    @Id
    @GeneratedValue(generator = "UUID")
    private var id: UUID = UUID.randomUUID(),
    val login: String,
    val password: String,
    val name: String,
    val surName: String
)