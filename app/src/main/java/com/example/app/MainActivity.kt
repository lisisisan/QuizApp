package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.content.Intent
import android.widget.Toast
import com.example.app.ui.QuestionsActivity
import com.example.app.ui.TranslateActivity
import com.example.app.utils.Constants

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton: Button = findViewById(R.id.button_start)
        val startTranslateButton: Button = findViewById(R.id.button_start_translate)
        val editTextName: EditText = findViewById(R.id.name)

        startButton.setOnClickListener {
            if (editTextName.text.isNotEmpty()) {
                Intent(this@MainActivity, QuestionsActivity::class.java).also {
                    it.putExtra(Constants.USER_NAME, editTextName.text.toString())
                    startActivity(it)
                    finish()
                }
            } else {
                Toast.makeText(this@MainActivity, "Пожалуйста введите своё имя", Toast.LENGTH_LONG).show()
            }
        }

        startTranslateButton.setOnClickListener {
            if (editTextName.text.isNotEmpty()) {
                Intent(this@MainActivity, TranslateActivity::class.java).also {
                    it.putExtra(Constants.USER_NAME, editTextName.text.toString())
                    startActivity(it)
                    finish()
                }
            } else {
                Toast.makeText(this@MainActivity, "Пожалуйста введите своё имя", Toast.LENGTH_LONG).show()
            }
        }
    }
}
