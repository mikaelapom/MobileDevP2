package com.maxli.coursegpa

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//used as db table for each course
@Entity(tableName = "questions")
class TrivialQuestion {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "questionId")
    var id: Int = 0

    @ColumnInfo(name = "questionName")
    var questionName: String = ""

    @ColumnInfo(name = "choiceA")
    var choiceA: String = ""

    @ColumnInfo(name = "choiceB")
    var choiceB: String = ""

    @ColumnInfo(name = "choiceC")
    var choiceC: String = ""

    @ColumnInfo(name = "choiceD")
    var choiceD: String = ""

    @ColumnInfo(name = "correctAnswer")
    var correctAnswer: String = ""  //we should probs limit this in a different file to be A, B, C, or D

    constructor()

    constructor(
        questionName: String,
        choiceA: String,
        choiceB: String,
        choiceC: String,
        choiceD: String,
        correctAnswer: String
    ) {
        this.questionName = questionName
        this.choiceA = choiceA
        this.choiceB = choiceB
        this.choiceC = choiceC
        this.choiceD = choiceD
        this.correctAnswer = correctAnswer
    }
}