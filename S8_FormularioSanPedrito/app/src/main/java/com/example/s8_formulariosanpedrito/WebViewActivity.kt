package com.example.s8_formulariosanpedrito

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        val webView = findViewById<WebView>(R.id.webView)
        val url = "https://chimboteonline.com/San_Pedrito/" // Aquí va la URL que desees
        webView.loadUrl(url)
    }
}
