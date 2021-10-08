package pl.codesencor.foodexchangebackend.product.response

class ProductResponse(
    val id: Long,
    val title: String,
    val description: String,
    val address: String,
    val owner: UserResponse
)
