package com.example.spacemanocr
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions

class MainActivity : Activity() {
    private lateinit var status: TextView
    private lateinit var result: TextView

    private val pickImageRequest = 1001
    private val recognizer by lazy {
        TextRecognition.getClient(
            TextRecognizerOptions.DEFAULT_OPTIONS
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
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
            text = "Pilih screenshot game untuk membaca teks."
            textSize = 16f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
            setPadding(0, 24, 0, 24)
        }

        val button = Button(this).apply {
            text = "PILIH SCREENSHOT"
            setOnClickListener { openImagePicker() }
        }

        result = TextView(this).apply {
            text = "Hasil OCR akan muncul di sini."
            textSize = 16f
            setTextColor(Color.rgb(220, 230, 245))
            setPadding(12, 16, 12, 16)
        }

        val scroll = ScrollView(this).apply {
            addView(result)
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        }

        layout.addView(title)
        layout.addView(status)
        layout.addView(button)
        layout.addView(scroll)
        setContentView(layout)
    }

    private fun openImagePicker() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "image/*"
        }
        startActivityForResult(intent, pickImageRequest)
    }

    @Deprecated("Kept for Android compatibility")
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode != pickImageRequest ||
            resultCode != RESULT_OK
        ) return

        val uri: Uri = data?.data ?: run {
            status.text = "Gambar tidak dipilih."
            return
        }

        status.text = "Sedang membaca teks..."
        result.text = ""

        try {
            val image = InputImage.fromFilePath(this, uri)

            recognizer.process(image)
                .addOnSuccessListener { visionText ->
                    val text = visionText.text.trim()

                    result.text = if (text.isBlank()) {
                        "Tidak ada teks terbaca. Coba screenshot lebih jelas."
                    } else {
                        text
                    }

                    status.text = "OCR selesai."
                }
                .addOnFailureListener { error ->
                    status.text = "OCR gagal."
                    result.text = error.localizedMessage
                        ?: "Tidak dapat membaca gambar."
                }
        } catch (error: Exception) {
            status.text = "Gambar tidak dapat dibuka."
            result.text = error.localizedMessage
                ?: "Coba pilih gambar lain."
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        recognizer.close()
    }
}
