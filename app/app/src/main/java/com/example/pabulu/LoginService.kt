package com.example.pabulu

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

object LoginService {
    val client = HttpClient(CIO)
    var logged = false
    var token = ""

    suspend fun register(username: String, password: String, name:String): Boolean {
        val response = client.post<HttpResponse>("http://217.182.78.140/api/auth/register"){
            contentType(ContentType.Application.Json)
            this.body = "{\"login\":\"$username\",\"password\":\"$password\",\"name\":\"$name\""
        }
        return response.status.value in 200..299
    }

    suspend fun login(username: String, password: String): Boolean {
        val response = client.post<HttpResponse>("http://217.182.78.140/api/auth/login"){
            contentType(ContentType.Application.Json)
        }
        return response.status.value in 200..299
    }
}