package com.jamesnyakush.workmanager.util

import android.util.Log

fun sleep() {
    try {
        Thread.sleep(1000, 0)
    } catch (e: InterruptedException) {
        Log.e("utils", e.message)
    }
}