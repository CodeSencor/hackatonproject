package com.example.pabulu

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        buttonReg.setOnClickListener {
            CoroutineScope(IO).launch {
                if (LoginService.register(emailEdit.text.toString(), passwordEdit.text.toString(), loginEdit.text.toString())) {
                    CoroutineScope(Main).launch {
                        Toast.makeText(applicationContext,
                            "Udało się zarejestrować", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@Register, Login::class.java))
                        finish()
                    }
                }
            }
        }
    }


}