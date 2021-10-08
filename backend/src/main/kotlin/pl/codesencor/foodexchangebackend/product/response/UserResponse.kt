package pl.codesencor.foodexchangebackend.product.response

data class UserResponse(
    val id: Long,
    val login: String,
    val name: String,
    val surName: String
    )
