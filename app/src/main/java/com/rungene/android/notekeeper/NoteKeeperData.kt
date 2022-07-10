package com.rungene.android.notekeeper

class CourseInfo(val courseId:String,val title:String?=null) {
    override fun toString(): String {
        return title.toString()
    }
}

data class NoteInfo(var course:String?,var title:String,var text:String)