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
           var course = courses["android_intent"]
            var note = course?.let {
                NoteInfo(
                    it, "Dynamic intent resolution",
                    "Wow, intents allow components to be resolved at runtime")
            }

            if (note != null) {
                notes.add(note)
            }
            note = course?.let {
                NoteInfo(
                    it, "Delegating intents",
                    "PendingIntents are powerful; they delegate much more than just a component invocation")
            }
            if (note != null) {
                notes.add(note)
            }

            course = courses["android_sync"]
            note = course?.let {
                NoteInfo(
                    it, "Service default threads",
                    "Did you know that by default an Android Service will tie up the UI thread?")
            }
            if (note != null) {
                notes.add(note)
            }
            note = course?.let {
                NoteInfo(
                    it, "Long running operations",
                    "Foreground Services can be tied to a notification icon")
            }
            if (note != null) {
                notes.add(note)
            }

            course = courses["java_lang"]
            note = course?.let {
                NoteInfo(
                    it, "Parameters",
                    "Leverage variable-length parameter lists")
            }
            if (note != null) {
                notes.add(note)
            }
            note = course?.let {
                NoteInfo(
                    it, "Anonymous classes",
                    "Anonymous classes simplify implementing one-use types")
            }
            if (note != null) {
                notes.add(note)
            }

            course = courses["java_core"]
            note = course?.let {
                NoteInfo(
                    it, "Compiler options",
                    "The -jar option isn't compatible with with the -cp option")
            }
            if (note != null) {
                notes.add(note)
            }
            note = course?.let {
                NoteInfo(
                    it, "Serialization",
                    "Remember to include SerialVersionUID to assure version compatibility")
            }
            if (note != null) {
                notes.add(note)
            }

        }
    }


}