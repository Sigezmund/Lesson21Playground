package com.teachmeskills.lesson21playground

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, MainFragment.newInstance())
                .commit()
        }
    }
}