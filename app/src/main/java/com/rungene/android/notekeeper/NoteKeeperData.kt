package com.rungene.android.notekeeper

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class CourseInfo(val courseId:String,val title:String?=null) {
    override fun toString(): String {
        return title.toString()
    }
}
@Parcelize
data class NoteInfo(var course:String?,var title:String,var text:String): Parcelable