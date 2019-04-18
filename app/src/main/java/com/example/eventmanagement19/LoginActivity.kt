package com.example.eventmanagement19

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.Toast
import com.example.eventmanagement19.Model.Student
import kotlinx.android.synthetic.main.activity_login.entry_username_login
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    lateinit var currentStudentId : String
    lateinit var currentOrganizerId : String
    lateinit var currentStudentName : String

    lateinit var loginString : String





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun onClickLogin(v: View){
        loginString = entry_username_login.text.toString()
        getStudentInformation()
    }

    fun saveInPreferences() {
        val saved_values = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val editor = saved_values.edit()
        editor.putString("currentStudentId", currentStudentId)
        editor.putString("currentOrganizerId", currentOrganizerId)

        //TODO: Delete this after test:
        editor.putString("currentStudentName", "Jan Duldhardt")



        editor.commit()
    }

    fun checkOrganizerId(){
        val call = RetrofitService().client.getIsOrganizer(currentStudentId.toLong())
        call.enqueue(object : Callback<Long>{
            override fun onFailure(call: Call<Long>, t: Throwable) {
                Toast.makeText(this@LoginActivity, t.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Long>, response: Response<Long>) {
                currentOrganizerId = response.body().toString()

                saveInPreferences()
                val intent = Intent(this@LoginActivity, SelectEventActivity::class.java)
                startActivity(intent)
            }
        })
    }

    fun getStudentInformation(){
        val call = RetrofitService().client.getStudentById(loginString.toLong())
        call.enqueue(object : Callback<Student>{
            override fun onFailure(call: Call<Student>, t: Throwable) {
                Toast.makeText(this@LoginActivity, t.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Student>, response: Response<Student>) {
                val responseStudent = response.body()!!
                currentStudentName = "${responseStudent.firstName} ${responseStudent.lastName}"
                currentStudentId = loginString

                checkOrganizerId()
            }
        })

    }

}
