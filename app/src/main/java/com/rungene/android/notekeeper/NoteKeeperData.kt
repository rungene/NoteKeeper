package com.rungene.android.notekeeper

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class CourseInfo(val courseId:String,val title:String) {
    override fun toString(): String {
        return title
    }
}
@Parcelize
data class NoteInfo(var courseTitle:String?, var title:String, var text:String): Parcelable