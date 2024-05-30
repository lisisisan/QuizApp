package com.example.app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.app.R
import com.example.app.model.TranslateQuestion
import com.example.app.utils.Constants

class TranslateActivity : AppCompatActivity() {
    private lateinit var textViewQuestion: TextView
    private lateinit var editTextAnswer: EditText
    private lateinit var textViewCorrectAnswer: TextView
    private lateinit var checkButton: Button

    private var questionsCounter = 0
    private lateinit var questionsList: List<TranslateQuestion>
    private lateinit var currentQuestion: TranslateQuestion
    private lateinit var name: String
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_translate)

        textViewQuestion = findViewById(R.id.text_view_question)
        editTextAnswer = findViewById(R.id.edit_text_answer)
        textViewCorrectAnswer = findViewById(R.id.text_view_correct_answer)
        checkButton = findViewById(R.id.button_check)

        questionsList = Constants.getTranslateQuestions().shuffled()

        if (intent.hasExtra(Constants.USER_NAME)) {
            name = intent.getStringExtra(Constants.USER_NAME)!!
        }

        showNextQuestion()

        checkButton.setOnClickListener {
            val answer = editTextAnswer.text.toString().trim()
            if (answer.isNotEmpty()) {
                checkAnswer(answer)
            } else {
                Toast.makeText(this, "Пожалуйста, введите ответ", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showNextQuestion() {
        if (questionsCounter < questionsList.size) {
            currentQuestion = questionsList[questionsCounter]
            textViewQuestion.text = currentQuestion.question
            editTextAnswer.text.clear()
            textViewCorrectAnswer.text = ""
            questionsCounter++
        } else {
            Intent(this, ResultActivity::class.java).also {
                it.putExtra(Constants.USER_NAME, name)
                it.putExtra(Constants.SCORE, score)
                it.putExtra(Constants.TOTAL_QUESTIONS, questionsList.size)
                startActivity(it)
            }
        }
    }

    private fun checkAnswer(answer: String) {
        if (answer.equals(currentQuestion.correctAnswer, ignoreCase = true)) {
            score++
            // Правильный ответ
            textViewCorrectAnswer.text = "Верно! Правильный ответ: ${currentQuestion.correctAnswer}"
            textViewCorrectAnswer.setTextColor(resources.getColor(android.R.color.holo_green_dark))
        } else {
            // Неправильный ответ
            textViewCorrectAnswer.text = "Неправильно. Правильный ответ: ${currentQuestion.correctAnswer}"
            textViewCorrectAnswer.setTextColor(resources.getColor(android.R.color.holo_red_dark))
        }
        // Показать сообщение о правильном ответе на короткое время перед переходом к следующему вопросу
        editTextAnswer.isEnabled = false
        checkButton.isEnabled = false
        textViewCorrectAnswer.postDelayed({
            // Показать следующий вопрос после задержки
            showNextQuestion()
            // Включить возможность ввода ответа и проверки
            editTextAnswer.isEnabled = true
            checkButton.isEnabled = true
        }, 2000) // Задержка в миллисекундах (например, 2000 мс = 2 секунды)
    }


}
