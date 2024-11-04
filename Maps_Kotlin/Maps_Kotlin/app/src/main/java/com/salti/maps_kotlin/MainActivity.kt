package com.salti.maps_kotlin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.salti.maps_kotlin.model.WisataActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //ini agar page full screen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        //spalsh screen
        //handle untuk delay selama beberapa detik
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, WisataActivity::class.java)
            startActivity(intent)
            finish() //agar ketika dia pindah ke page ke 2, itu gak back ke splash screen
        }, 3000)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //TASK
        //PADA PAGE START SCREEN 2 --> klik button Get Started akan pindah ke page login
        //Page page login, ketika klik tulisan did not have account --> pindah ke page signup
        //page page signup, ketika tulisan have account --> pindah ke page login
    }
}