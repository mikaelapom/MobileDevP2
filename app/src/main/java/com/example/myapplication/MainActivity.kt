package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.runtime.*

val TimesNewRoman = FontFamily(
    Font(R.font.times, FontWeight.Normal),
    Font(R.font.times, FontWeight.Bold),
    Font(R.font.times, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.times, FontWeight.Bold, FontStyle.Italic)
)

var questionNumber by mutableIntStateOf(1)
var QuestionsAnswered: Int = 0
var QuestionsCorrect: Int = 0
var QuestionsWrong: Int = 0 //Might not need -Diana

class Question(val question: String, val correctAnswer: String, val wrong1: String, val wrong2: String, val wrong3: String) {
    fun getAllOptions(): List<String> {
        return listOf(correctAnswer, wrong1, wrong2, wrong3).shuffled()
    }
}

val TestQuestion1 = Question("Test Question",
    "Test Answer",
    "Test Wrong",
    "Test Wrong",
    "Test Wrong")

val TestQuestion2 = Question("Test Question2",
    "Test Answer2",
    "Test Wrong2",
    "Test Wrong2",
    "Test Wrong2")

var questionsList = listOf(TestQuestion1, TestQuestion2)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        TopBanner()
                        SecondBanner()
                        QuestionBox()
                        AnswerOne()
                        AnswerTwo()
                        AnswerThree()
                        AnswerFour()
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondBanner() {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(Color(0xFFFBE475))
            , contentAlignment = Alignment.Center
        )
        {

            Text(text = "Trivia Questionaire",
                style = TextStyle(
                    fontFamily = TimesNewRoman,
                    fontSize = 30.sp,
                    color = Color(0xFF1A2C57)
                ))
        }
    }
}
@Composable
fun TopBanner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color(0xFFFBE475)),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 4.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.smith),
                contentDescription = "Smith College Logo",
                modifier = Modifier
                    .size(100.dp)
                    .padding(end = 8.dp)
            )

            Text(
                text = "Smith College",
                style = TextStyle(
                    fontFamily = TimesNewRoman,
                    fontSize = 35.sp,
                    color = Color(0xFF1A2C57)
                )
            )
        }

    }
}

@Composable
fun QuestionBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = "Question $questionNumber: ${questionsList[questionNumber - 1].question}",
            style = TextStyle(
                fontFamily = TimesNewRoman,
                fontSize = 25.sp,
                color = Color(0xFF1A2C57)
            )
        )
    }
}
@Composable
fun AnswerOne() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = {
                questionNumber++
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF97CDEC),
                contentColor = Color(0xFF1A2C57)
            ),
            shape = CircleShape,
            modifier = Modifier.size(50.dp)
        ) {
            Text(
                text = "A",
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontFamily = TimesNewRoman,
                    fontSize = 25.sp,
                    color = Color(0xFF1A2C57)
                )
            )
        }
        Text(
            text = "${questionsList[questionNumber - 1].correctAnswer}",
            style = TextStyle(
                fontFamily = TimesNewRoman,
                fontSize = 25.sp,
                color = Color(0xFF1A2C57)
            )
        )
    }
}

@Composable
fun AnswerTwo() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = {
                questionNumber++
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF97CDEC),
                contentColor = Color(0xFF1A2C57)
            ),
            shape = CircleShape,
            modifier = Modifier.size(50.dp)
        ) {
            Text(
                text = "B",
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontFamily = TimesNewRoman,
                    fontSize = 25.sp,
                    color = Color(0xFF1A2C57)
                )
            )
        }
        Text(
            text = "${questionsList[questionNumber - 1].wrong1}",
            style = TextStyle(
                fontFamily = TimesNewRoman,
                fontSize = 25.sp,
                color = Color(0xFF1A2C57)
            )
        )
    }
}

@Composable
fun AnswerThree() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = {
                questionNumber++
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF97CDEC),
                contentColor = Color(0xFF1A2C57)
            ),
            shape = CircleShape,
            modifier = Modifier.size(50.dp)
        ) {
            Text(
                text = "C",
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontFamily = TimesNewRoman,
                    fontSize = 25.sp,
                    color = Color(0xFF1A2C57)
                )
            )
        }
        Text(
            text = "${questionsList[questionNumber - 1].wrong2}",
            style = TextStyle(
                fontFamily = TimesNewRoman,
                fontSize = 25.sp,
                color = Color(0xFF1A2C57)
            )
        )
    }
}

@Composable
fun AnswerFour() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = {
                questionNumber++
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF97CDEC),
                contentColor = Color(0xFF1A2C57)
            ),
            shape = CircleShape,
            modifier = Modifier.size(50.dp)
        ) {
            Text(
                text = "D",
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontFamily = TimesNewRoman,
                    fontSize = 25.sp,
                    color = Color(0xFF1A2C57)
                )
            )
        }
        Text(
            text = "${questionsList[questionNumber - 1].wrong3}",
            style = TextStyle(
                fontFamily = TimesNewRoman,
                fontSize = 25.sp,
                color = Color(0xFF1A2C57)
            )
        )
    }
}