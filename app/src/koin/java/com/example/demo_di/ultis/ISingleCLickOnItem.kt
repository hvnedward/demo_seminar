package com.example.demo_di.ultis

import android.content.Context
import android.widget.Toast

class ISingleCLickOnItem (val context: Context) : ISingleClick<Any> {
    override fun singleClick(ob: Any): Any {
        Toast.makeText(context, "Item + count: ", Toast.LENGTH_SHORT).show()
        return 1
    }
}