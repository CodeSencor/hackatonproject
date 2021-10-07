package com.example.pabulu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.view.View
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class UserOffer : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_offer)
        var dLayout = findViewById<DrawerLayout>(R.id.userOffer)
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
        var countryNames = arrayOf(
            "China",
            "Russia",
            "US"
        )
        var countryFlags = intArrayOf(
            R.drawable.flag_china,
            R.drawable.flag_russia,
            R.drawable.flag_us
        )
        var mListView = findViewById<View>(R.id.listview) as ListView
        val myAdapter = ListAdapter(this@UserOffer, countryNames, countryFlags)
        mListView.setAdapter(myAdapter)
        mListView.setOnItemClickListener { adapterView, view, i, l ->
            val mIntent = Intent(this@UserOffer, OfferDetails::class.java)
            mIntent.putExtra("countryName", countryNames[i])
            mIntent.putExtra("countryFlag", countryFlags[i])
            startActivity(mIntent)
        }
    }
}