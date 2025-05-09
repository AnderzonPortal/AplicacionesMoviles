package com.example.holaappkt

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.widget.Button
import android.widget.EditText
import android.widget.TextView



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val valA = findViewById<EditText>(R.id.valA)
        val valB = findViewById<EditText>(R.id.valB)
        val btnMul = findViewById<Button>(R.id.btnMul)
        val tvRes = findViewById<TextView>(R.id.tvRes)

        btnMul.setOnClickListener{
            val a = valA.text.toString().trim()
            val b = valB.text.toString().trim()
            if (a.isNotEmpty() && b.isNotEmpty()) {
                val result = a.toDouble() * b.toDouble()
                tvRes.text = "El resultado es $result"
            }

        }

//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}