package com.example.pabulu

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var dLayout = findViewById<DrawerLayout>(R.id.activityMain)
        var nView = findViewById<NavigationView>(R.id.navView)

        toggle = ActionBarDrawerToggle(this, dLayout, R.string.open, R.string.close)
        dLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.miItem1 -> startActivity(Intent(this,MainActivity::class.java))
                R.id.miItem2 -> startActivity(Intent(this,UserOffer::class.java))
                R.id.miItem3 -> Toast.makeText(applicationContext,
                    "Clicked Item 3", Toast.LENGTH_SHORT).show()
                R.id.miItem4 -> Toast.makeText(applicationContext,
                    "Clicked Item 4", Toast.LENGTH_SHORT).show()
                R.id.miItem5 -> Toast.makeText(applicationContext,
                    "Clicked Item 5", Toast.LENGTH_SHORT).show()
            }
            true
        }
            val btnAddOffer = findViewById<Button>(R.id.btnAddOffer)

//            btnAddOffer.setOnClickListener{
//                val Intent = Intent(this,AddOfferScreen::class.java)
//            }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}