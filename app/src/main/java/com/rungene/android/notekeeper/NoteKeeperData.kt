package com.rungene.android.notekeeper

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class CourseInfo(val courseId:String,val title:String) :Parcelable{
    override fun toString(): String {
        return title
    }
}
@Parcelize
data class NoteInfo(var courseTitle:String?, var title:String, var text:String): Parcelable