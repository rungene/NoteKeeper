package com.rungene.android.notekeeper.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NoteInfo(var courseTitle:String?, var title:String, var text:String): Parcelable