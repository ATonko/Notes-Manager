package com.example.notesmanager.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.concurrent.Executors

@Database(entities = [NoteRoomEntity::class], version = 1)
internal abstract class AppDatabase : RoomDatabase() {
    abstract fun getDao(): NoteDao


    companion object {
        private const val databaseName = "Notes.db"

        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase = instance ?: createInstance(context).also { instance = it }

        private fun createInstance(context: Context): AppDatabase =
                Room.databaseBuilder(context, AppDatabase::class.java, databaseName).build()
    }

}