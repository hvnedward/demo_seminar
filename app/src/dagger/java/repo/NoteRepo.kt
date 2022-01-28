package repo

import com.example.demo_di.model.Note
import service.NoteDao

class NoteRepo constructor(val noteDao: NoteDao){
    suspend fun getAllNote() = noteDao.getAllNotes()
    suspend fun insertAllNote (notes:List<Note>) = noteDao.insertAllList(notes)
}