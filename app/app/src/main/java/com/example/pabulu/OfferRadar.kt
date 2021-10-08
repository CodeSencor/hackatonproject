package com.example.pabulu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.view.View
import android.widget.ListView


class OfferRadar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offer_radar)
        var offerNames = arrayOf(
            "China",
            "Russia",
            "US"
        )
        var offerPhotos = intArrayOf(
            R.drawable.flag_china,
            R.drawable.flag_russia,
            R.drawable.flag_us
        )
        var mListView = findViewById<View>(R.id.listview) as ListView
        val myAdapter = ListAdapter(this@OfferRadar, offerNames, offerPhotos)
        mListView.setAdapter(myAdapter)
        mListView.setOnItemClickListener { adapterView, view, i, l ->
            val mIntent = Intent(this@OfferRadar, OfferDetails::class.java)
            mIntent.putExtra("countryName", offerNames[i])
            mIntent.putExtra("countryFlag", offerPhotos[i])
            startActivity(mIntent)
        }
    }
}