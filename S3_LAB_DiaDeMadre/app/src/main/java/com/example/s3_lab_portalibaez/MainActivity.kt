package com.example.s3_lab_portalibaez

import android.animation.Animator
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {

    private lateinit var lottieView: LottieAnimationView
    private lateinit var btnSorpresa: Button
    private lateinit var mensajeSorpresa: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lottieView = findViewById(R.id.lottieView)
        btnSorpresa = findViewById(R.id.btnSorpresa)
        mensajeSorpresa = findViewById(R.id.mensajeSorpresa)

        mensajeSorpresa.visibility = View.GONE

        btnSorpresa.setOnClickListener {
            mensajeSorpresa.visibility = View.GONE
            lottieView.playAnimation()
        }

        lottieView.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {}
            override fun onAnimationEnd(animation: Animator) {
                mensajeSorpresa.visibility = View.VISIBLE
                val fadeIn = AlphaAnimation(0f, 1f)
                fadeIn.duration = 600
                mensajeSorpresa.startAnimation(fadeIn)
            }
            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
    }
}
