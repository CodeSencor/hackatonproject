package pl.codesencor.foodexchangebackend.user

import org.hibernate.annotations.GenericGenerator
import pl.codesencor.foodexchangebackend.util.AbstractBaseEntity
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class User(
    id: UUID? = null
) : AbstractBaseEntity(id)