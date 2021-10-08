package com.example.pabulu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.engine.cio.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }
    fun login(){
        val client = HttpClient(CIO)
/*        val response = client.request("http://localhost:8080/api/auth/login"){

        }*/
    }
}