package pl.codesencor.foodexchangebackend.product.request

data class ProductCreationRequest(
    val title: String,
    val description: String,
    val address: String
)
