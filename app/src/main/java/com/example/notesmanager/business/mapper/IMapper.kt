package com.example.notesmanager.business.mapper

import android.os.Parcelable

internal interface IMapper<A,B: Parcelable>{

    fun mapFrom(from:A?):B?

    fun mapFrom(from:B?):A?

}