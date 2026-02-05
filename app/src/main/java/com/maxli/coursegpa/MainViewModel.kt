package com.maxli.coursegpa

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(application: Application) : ViewModel() {

    val allCourses: LiveData<List<Course>>
    private val repository: CourseRepository
    val searchResults: MutableLiveData<List<Course>>

    init {
        val courseDb = CourseRoomDatabase.getInstance(application)
        val courseDao = courseDb.courseDao()
        repository = CourseRepository(courseDao)

        allCourses = repository.allCourses
        searchResults = repository.searchResults
    }

    fun insertCourse(course: Course) {
        repository.insertCourse(course)
    }

//    fun findCourse(name: String) {
//        repository.findCourse(name)
//    }

    fun deleteCourse(id: Int) {
        repository.deleteCourse(id)
    }

    fun smartSearch(courseName: String?, creditHour: String?, letterGrade: String?) {
        repository.smartSearch(courseName, creditHour, letterGrade)
    }
}