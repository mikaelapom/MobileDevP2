package com.maxli.coursegpa

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.*

class TrivialViewModel(
    private val dao: TrivialQuestionDao
) : ViewModel() {

    var allQuestions by mutableStateOf<List<TrivialQuestion>>(emptyList())
        private set

    var selectedQuestions by mutableStateOf<List<TrivialQuestion>>(emptyList())
        private set

    var userAnswers = mutableStateMapOf<Int, String>()
        private set

    // Load button
    fun loadQuestions() {
        viewModelScope.launch {
            dao.deleteAllQuestions()

            // You will insert all 10 questions here
            dao.insertQuestion(
                TrivialQuestion(
                    "When was XYZ University founded?",
                    "1890",
                    "1901",
                    "1923",
                    "1950",
                    "A"
                )
            )

            // repeat until 10 total

            allQuestions = dao.getAllQuestions()
        }
    }

    fun pickRandomQuestions(n: Int) {
        selectedQuestions = allQuestions.shuffled().take(n)
        userAnswers.clear()
    }

    fun answerQuestion(questionId: Int, answer: String) {
        userAnswers[questionId] = answer
    }

    fun allAnswered(): Boolean {
        return selectedQuestions.all { userAnswers.containsKey(it.id) }
    }

    fun grade(): String {
        val correct = selectedQuestions.count {
            userAnswers[it.id] == it.correctAnswer
        }
        return "$correct/${selectedQuestions.size}"
    }
}
