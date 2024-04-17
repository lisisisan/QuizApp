package com.example.app.utils

import com.example.app.R
import com.example.app.model.Question

object Constants {

    const val USER_NAME = "user_name"
    const val TOTAL_QUESTIONS = "total_questions"
    const val SCORE = "correct_answers"

    fun getQuestions(): MutableList<Question> {
        val questions = mutableListOf<Question>()

        val quest1 = Question(
            1, "Что изображено на картинке?", R.drawable.cat1,
            "cat", "owl", "ox", "snake",
            1
        )
        questions.add(quest1)

        val quest2 = Question(
            2, "Что изображено на картинке?", R.drawable.bee2,
            "lamb", "kitten", "bee", "mule",
            3
        )
        questions.add(quest2)

        val quest3 = Question(
            3, "Что изображено на картинке?", R.drawable.snail3,
            "peacock", "snail", "camel", "cobra",
            2
        )
        questions.add(quest3)

        val quest4 = Question(
            4, "Что изображено на картинке?", R.drawable.cobra4,
            "snail", "peacock", "camel", "cobra",
            4
        )
        questions.add(quest4)


        val quest5 = Question(
            5, "Что изображено на картинке?", R.drawable.peacock5,
            "snail", "peacock", "camel", "cobra",
            2
        )
        questions.add(quest5)


        val quest6 = Question(
            6, "Что изображено на картинке?", R.drawable.camel6,
            "snail", "peacock", "camel", "cobra",
            3
        )
        questions.add(quest6)


        val quest7 = Question(
            7, "Что изображено на картинке?", R.drawable.lamb7,
            "bee", "lamb", "mule", "kitten",
            2
        )
        questions.add(quest7)

        val quest8 = Question(
            8, "Что изображено на картинке?", R.drawable.mule8,
            "kitten", "bee", "lamb", "mule",
            4
        )
        questions.add(quest8)

        val quest9 = Question(
            9, "Что изображено на картинке?", R.drawable.owl9,
            "owl", "cat", "ox", "snake",
            1
        )
        questions.add(quest9)

        val quest10 = Question(
            10, "Что изображено на картинке?", R.drawable.ox10,
            "owl", "cat", "ox", "snake",
            3
        )
        questions.add(quest10)

        return questions
    }
}