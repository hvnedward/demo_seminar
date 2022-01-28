package com.example.demo_di.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.demo_di.model.Note

@Dao
interface NoteDao {
    @Query("select * from note")
    suspend fun  getAllNote(): List<Note>

    @Insert(onConflict = REPLACE)
    suspend fun insertANote(note: Note)
    @Insert(onConflict = REPLACE)
    suspend fun insertNotes(note: List<Note>)
}