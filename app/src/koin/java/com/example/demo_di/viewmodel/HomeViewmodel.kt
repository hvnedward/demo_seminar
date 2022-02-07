package com.example.demo_di.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo_di.model.Note
import com.example.demo_di.repo.NoteRepo
import kotlinx.coroutines.launch

class HomeViewModel(val noteRepo: NoteRepo) :ViewModel(){
     val data:MutableLiveData<List<Note>> = MutableLiveData()
    fun getAllNotes(){
        viewModelScope.launch {
            data.postValue(noteRepo.getAllNote())
        }
    }
    fun insertNotes(data:List<Note>){
        viewModelScope.launch {
            noteRepo.insertNotes(data)
        }
    }
}