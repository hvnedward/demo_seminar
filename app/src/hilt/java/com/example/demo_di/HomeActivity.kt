package com.example.demo_di

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.demo_di.model.Note
import com.example.demo_di.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.lang.reflect.Array
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private val TAG = HomeActivity::class.java.simpleName
    private val homeViewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var d:ArrayList<Note> = ArrayList()
        for(i :Int in 10..200){
            val note = Note.Builder()
            note.title("duc")
            note.createdDate=10000
            d.add(note.build())

        }
        homeViewModel.insertNotes(d)
        homeViewModel.getAllNotes()
        homeViewModel.noteList.observe(this, object : Observer<List<Note>>{
            override fun onChanged(t: List<Note>?) {
                Log.d(TAG, "onChanged: "+ t.toString())
            }

        })
    }
}