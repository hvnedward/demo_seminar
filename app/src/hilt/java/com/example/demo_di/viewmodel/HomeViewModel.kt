package com.example.demo_di.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo_di.model.Note
import com.example.demo_di.repo.NoteRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val repo: NoteRepo) : ViewModel() {
    val noteList = MutableLiveData<List<Note>>()
    fun getAllNotes() {
        viewModelScope.launch {
            noteList.value = repo.getAllNote()
        }

    }

    suspend fun insertANote(note: Note) {
        repo.insertANote(note)
    }

     fun insertNotes(note: List<Note>) {
        viewModelScope.launch {
            repo.insertNotes(note)
        }

    }
}