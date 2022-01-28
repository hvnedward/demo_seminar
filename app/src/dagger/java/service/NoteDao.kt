package service

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.demo_di.model.Note

@Dao
interface NoteDao {
    @Query("select * from note")
    suspend fun getAllNotes(): LiveData<List<Note>>

    @Query("select * from note order by :sort")
    suspend fun getAllNotesWithSortPriority(sort: String): LiveData<List<Note>>

    @Insert
    suspend fun insertNote(note: Note)
    @Insert
    suspend fun insertAllList(notes: List<Note>)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("delete from note")
    suspend fun deleteAll()
}