
package com.example.spacemanocr

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    private lateinit var status: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(24, 24, 24, 24)
            setBackgroundColor(Color.rgb(18, 24, 38))
        }

        val title = TextView(this).apply {
            text = "SPACEMAN OCR SIGNAL"
            textSize = 24f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
        }

        status = TextView(this).apply {
            text = "Tekan tombol untuk memulai."
            textSize = 18f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
            setPadding(0, 32, 0, 32)
        }

        val button = Button(this).apply {
            text = "PERIKSA STATUS"
            setOnClickListener {
                status.text =
                    "Aplikasi aktif.\nOCR belum diaktifkan.\n" +
                    "Sinyal belum tersedia."
            }
        }

        layout.addView(title)
        layout.addView(status)
        layout.addView(button)
        setContentView(layout)
    }
}
