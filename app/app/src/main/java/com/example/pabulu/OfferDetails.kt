package com.example.pabulu

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity

class OfferDetails : AppCompatActivity() {
    var mToolbar: Toolbar? = null
    var mImageView: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offer_details)
        mImageView = findViewById<View>(R.id.offerPhoto) as ImageView
        val mBundle = intent.extras
        if (mBundle != null) {
            mImageView!!.setImageResource(mBundle.getInt("countryFlag"))
        }
    }
}