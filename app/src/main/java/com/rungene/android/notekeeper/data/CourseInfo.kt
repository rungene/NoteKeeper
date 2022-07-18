package com.rungene.android.notekeeper.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class CourseInfo(val courseId:String,val title:String) :Parcelable{
    override fun toString(): String {
        return title
    }
}
