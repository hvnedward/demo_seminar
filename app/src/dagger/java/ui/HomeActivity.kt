package ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demo_di.R
import viewmodel.HomeViewmodel

class HomeActivity : AppCompatActivity() {
    lateinit var homeViewmodel:HomeViewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}