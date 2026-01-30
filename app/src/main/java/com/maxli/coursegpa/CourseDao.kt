package com.maxli.coursegpa


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CourseDao {

    //to do: add error message if they are missing an input 
    @Insert
    fun insertCourse(course: Course)

    //for searching
    //this was originally exact matches only so i changed it to be like name instead
    @Query("SELECT * FROM courses WHERE courseName LIKE :name")
    fun findCourse(name: String): List<Course>

    //to do: find courses based on grade or credit hour instead of just name

    @Query("DELETE FROM courses WHERE courseName = :name")
    fun deleteCourse(name: String)

    @Query("SELECT * FROM courses")
    fun getAllCourses(): LiveData<List<Course>>


}