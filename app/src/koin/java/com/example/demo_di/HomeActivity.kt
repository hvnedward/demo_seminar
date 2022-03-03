package com.example.demo_di

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.demo_di.model.Note
import com.example.demo_di.ultis.ISingleClick
import com.example.demo_di.viewmodel.HomeViewModel
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.context.stopKoin
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.parameter.ParametersHolder
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named
import java.util.*

class HomeActivity : AppCompatActivity() {
    private var count:Int =0;
    //lazy
    // val homeViewModel: HomeViewModel by viewModel()

    //non lazy
    private lateinit var homeViewModel: HomeViewModel
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_home)
        val view = findViewById<View>(android.R.id.content).rootView
        homeViewModel = getViewModel()
        textView = findViewById(R.id.tv)
        initData()
        homeViewModel.data.observe(this,
            { t ->
                run {
                    Log.d("TAG", "onCreate: " + t.toString())
                    textView.text = t.toString()
                }
            })
        textView.setOnClickListener {
            val click: ISingleClick<Any> = get ()
            click.singleClick(2)
        }
        view.setOnClickListener {
            count++
            val click : ISingleClick<Any> by inject (qualifier = named("screen"))

        }
    }

    private fun initData() {
        var d = ArrayList<Note>()
        for (i: Int in 10..20) {
            val note = Note.Builder()
            note.title("duc")
            note.createdDate = 10000
            d.add(note.build())
        }
        homeViewModel.insertNotes(d)
        homeViewModel.getAllNotes()
    }
    //can drop or clear koin by calling stopKoin()
}