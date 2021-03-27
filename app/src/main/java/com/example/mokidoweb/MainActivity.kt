package com.example.mokidoweb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mwebView: WebView = findViewById<WebView>(R.id.webView) as WebView
        mwebView.loadUrl("http://mokido.co.in")

        val webSetting: WebSettings =mwebView.settings
        webSetting.javaScriptEnabled=true
        mwebView.webViewClient= WebViewClient()

        mwebView.canGoBack()
        mwebView.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK

                && event.action == MotionEvent.ACTION_UP
                && mwebView.canGoBack()
            ) {
                mwebView.goBack()
                return@OnKeyListener true
            }
            false
        })

    }
}