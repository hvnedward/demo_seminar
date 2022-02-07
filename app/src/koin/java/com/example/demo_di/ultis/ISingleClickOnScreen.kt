package com.example.demo_di.ultis

import android.content.Context
import android.widget.Toast

class ISingleClickOnScreen(val context: Context) : ISingleClick<Any> {
    override fun singleClick(ob: Any): Any {
        Toast.makeText(context, "OnScreen", Toast.LENGTH_SHORT).show()
        return ob
    }
}