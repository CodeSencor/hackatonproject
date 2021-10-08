package pl.codesencor.foodexchangebackend.product

import org.modelmapper.ModelMapper
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.HttpClientErrorException
import pl.codesencor.foodexchangebackend.jwt.UserDetailsImpl
import pl.codesencor.foodexchangebackend.product.request.ProductCreationRequest
import pl.codesencor.foodexchangebackend.product.response.ProductResponse
import pl.codesencor.foodexchangebackend.response.MessageResponse
import pl.codesencor.foodexchangebackend.user.UserRepository
import java.security.Principal

@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/api/product")
class ProductController(
    private val productRepository: ProductRepository,
    private val userRepository: UserRepository
) {

    private val mapper = ModelMapper()

    @PostMapping("create")
    fun createProduct(
        authentication: Authentication,
        @RequestBody request: ProductCreationRequest
    ): ResponseEntity<MessageResponse> {
        val userDetails = authentication.principal as UserDetails
        val user = userRepository.findByLogin(userDetails.username)
            ?: return ResponseEntity.badRequest().body(MessageResponse("u fucked up"))
        val product = Product(
            title = request.title,
            description = request.description,
            address = request.address,
            owner = user
        )

        productRepository.save(product)

        return ResponseEntity.ok(MessageResponse("Created product"))
    }

    @GetMapping("all")
    fun getAllProducts(): List<ProductResponse> {
        return productRepository.findAll().map { it.toProductResponse() }
    }

}