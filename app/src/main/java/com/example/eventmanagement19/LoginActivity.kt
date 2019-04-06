package com.example.eventmanagement19

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import kotlinx.android.synthetic.main.activity_login.entry_username_login

class LoginActivity : AppCompatActivity() {

    lateinit var currentStudentId : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun onClickLogin(v: View){
        currentStudentId = entry_username_login.text.toString()
        saveInPreferences()
        val intent = Intent(this, SelectEventActivity::class.java)
        startActivity(intent)
    }

    fun saveInPreferences() {
        val saved_values = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val editor = saved_values.edit()
        editor.putString("currentStudentId", currentStudentId)
        editor.commit()
    }
}
