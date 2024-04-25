package ai.onnxruntime.example.imageclassifier

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.content.Intent
import android.widget.Toast
import com.example.app.utils.Constants

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton: Button = findViewById(R.id.button_start)
        val editTextName: EditText = findViewById(R.id.name)
        val trainButton: Button = findViewById(R.id.button_train)

        trainButton.setOnClickListener {
            Intent(this@MainActivity, TrainActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }

        startButton.setOnClickListener {
            if (!editTextName.text.isEmpty()) {
                Intent(this@MainActivity, QuestionsActivity::class.java).also {
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