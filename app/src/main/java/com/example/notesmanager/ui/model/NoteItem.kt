package com.example.notesmanager.ui.model

import android.os.Parcelable
import com.example.notesmanager.utils.Constants.EMPTY_STRING
import kotlinx.android.parcel.Parcelize

@Parcelize
internal data class NoteItem(
    val id: String,
    val title: String,
    var content: String = EMPTY_STRING
) : Parcelable