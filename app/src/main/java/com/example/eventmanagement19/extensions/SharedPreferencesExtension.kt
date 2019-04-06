package com.example.eventmanagement19.extensions

import android.content.Context
import android.preference.PreferenceManager

fun loadCurrentStudentId(context : Context) : String {
    val saved_values = PreferenceManager.getDefaultSharedPreferences(context)
    return saved_values.getString("currentStudentId", "Student not found")!!
}

fun loadCurrentStudentName(context : Context) : String {
    val saved_values = PreferenceManager.getDefaultSharedPreferences(context)
    return saved_values.getString("currentStudentName", "Student not found")!!
}