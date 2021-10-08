package pl.codesencor.foodexchangebackend.product

import pl.codesencor.foodexchangebackend.product.response.ProductResponse
import pl.codesencor.foodexchangebackend.user.User
import javax.persistence.*

@Entity
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var title: String,
    @Column(length = 300)
    var description: String,
    var address: String,
    @ManyToOne(fetch = FetchType.LAZY)
    var owner: User
) {
    fun toProductResponse()= ProductResponse(
        id = id,
        title = title,
        description = description,
        address = address,
        owner = owner.toUserResponse()
    )
}