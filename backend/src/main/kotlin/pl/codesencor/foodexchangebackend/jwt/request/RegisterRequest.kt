package pl.codesencor.foodexchangebackend.jwt.request

data class RegisterRequest(
    val login: String,
    val password: String,
    val name: String,
    val surname: String
)