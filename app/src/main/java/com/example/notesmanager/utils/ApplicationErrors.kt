package com.example.notesmanager.utils

sealed class ApplicationErrors : Throwable()

class NoteToSaveNullError : ApplicationErrors()