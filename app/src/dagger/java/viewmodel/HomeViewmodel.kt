package viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demo_di.model.Note
import repo.NoteRepo

class HomeViewmodel(val noteRepo: NoteRepo) : ViewModel() {
    var noteList: LiveData<List<Note>> = MutableLiveData<List<Note>>()
    suspend fun getAllNote() {
        noteList = noteRepo.getAllNote()
    }

    suspend fun insertNote(note: List<Note>) {
        noteRepo.insertAllNote(notes = note)
    }
}