package com.example.kotlin2dz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fragmentManager = supportFragmentManager

        fragmentManager.beginTransaction()
            .replace(R.id.fragment_container, GalleryFragment())
            .commit()
    }
}