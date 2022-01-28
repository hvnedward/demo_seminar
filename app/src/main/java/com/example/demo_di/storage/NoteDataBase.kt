package com.example.demo_di.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.demo_di.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDataBase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao

}