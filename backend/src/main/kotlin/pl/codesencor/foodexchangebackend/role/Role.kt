package pl.codesencor.foodexchangebackend.role

import pl.codesencor.foodexchangebackend.jwt.ERole
import javax.persistence.*

@Entity
class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    var name: ERole
)