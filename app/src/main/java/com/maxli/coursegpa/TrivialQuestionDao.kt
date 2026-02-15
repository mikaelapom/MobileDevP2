package com.maxli.coursegpa

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

//we are probably gonna add more to this, but here is a start
@Dao
interface TrivialQuestionDao {

    @Insert
    suspend fun insertQuestion(question: TrivialQuestion)

    @Query("SELECT * FROM questions")
    suspend fun getAllQuestions(): List<TrivialQuestion>

    @Query("DELETE FROM questions")
    suspend fun deleteAllQuestions()
}
