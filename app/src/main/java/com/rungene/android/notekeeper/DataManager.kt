package com.rungene.android.notekeeper

object DataManager {
    val courses = HashMap<String,CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourse()
    }

    private fun initializeCourse(){
        var course = CourseInfo("android_intent","Android Programing With Intents")
        courses.set(course.courseId,course)

         course = CourseInfo("android_sync","Android Sync Programing and services")
        courses.set(course.courseId,course)

         course = CourseInfo(title = "Java Fundamentals :Jave Language", courseId = "java_lang")
        courses.set(course.courseId,course)

         course = CourseInfo("java_core","Java Fundamentals : The Core platform")
        courses.set(course.courseId,course)

    }
}