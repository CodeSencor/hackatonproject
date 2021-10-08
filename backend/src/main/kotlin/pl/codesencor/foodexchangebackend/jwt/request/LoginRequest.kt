package pl.codesencor.foodexchangebackend.jwt.request

data class LoginRequest(
    val login: String,
    val password: String
)
