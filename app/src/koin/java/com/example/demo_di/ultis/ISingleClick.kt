package com.example.demo_di.ultis

import android.content.Context

interface ISingleClick<T>{
    fun singleClick(ob:T):T
}