package com.rungene.android.notekeeper

import com.rungene.android.notekeeper.data.CourseInfo
import com.rungene.android.notekeeper.data.NoteInfo

object DataManager {


    val courses :MutableMap<String,CourseInfo> by lazy {
        mutableMapOf<String,CourseInfo>().also {
            courses ->          var course = CourseInfo("android_intent","Android Programing With Intents")
            courses.set(course.courseId,course)

            course = CourseInfo("android_sync","Android Sync Programing and services")
            courses.set(course.courseId,course)

            course = CourseInfo(title = "Java Fundamentals :Jave Language", courseId = "java_lang")
            courses.set(course.courseId,course)

            course = CourseInfo("java_core","Java Fundamentals : The Core platform")
            courses.set(course.courseId,course)

        }
    }
    val notes : MutableList<NoteInfo> by lazy {
        mutableListOf<NoteInfo>().also { notes ->
           var course = courses["android_intent"].toString()
            var note = NoteInfo(course, "Dynamic intent resolution",
                "Wow, intents allow components to be resolved at runtime")
            DataManager.notes.add(note)
            note = NoteInfo(course, "Delegating intents",
                "PendingIntents are powerful; they delegate much more than just a component invocation")
            DataManager.notes.add(note)

            course = courses["android_sync"].toString()
            note = NoteInfo(course, "Service default threads",
                "Did you know that by default an Android Service will tie up the UI thread?")
            DataManager.notes.add(note)
            note = NoteInfo(course, "Long running operations",
                "Foreground Services can be tied to a notification icon")
            DataManager.notes.add(note)

            course = courses["java_lang"].toString()
            note = NoteInfo(course, "Parameters",
                "Leverage variable-length parameter lists")
            DataManager.notes.add(note)
            note = NoteInfo(course, "Anonymous classes",
                "Anonymous classes simplify implementing one-use types")
            DataManager.notes.add(note)

            course = courses["java_core"].toString()
            note = NoteInfo(course, "Compiler options",
                "The -jar option isn't compatible with with the -cp option")
            DataManager.notes.add(note)
            note = NoteInfo(course, "Serialization",
                "Remember to include SerialVersionUID to assure version compatibility")
            DataManager.notes.add(note)

        }
    }


}