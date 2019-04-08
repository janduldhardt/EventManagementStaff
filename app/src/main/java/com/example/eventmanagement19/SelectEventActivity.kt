package com.example.eventmanagement19

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.eventmanagement19.Model.Event
import com.example.eventmanagement19.extensions.EventAdapter
import com.example.eventmanagement19.extensions.loadCurrentStudentId
import com.example.eventmanagement19.extensions.loadCurrentStudentName
import kotlinx.android.synthetic.main.activity_select_event.RecyclerViewSelectEvent
import kotlinx.android.synthetic.main.activity_select_event.student_header
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SelectEventActivity : AppCompatActivity() {

    lateinit var currentStudentId: String
    lateinit var currentStudentName: String

    val client = RetrofitService().client


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_event)
        currentStudentId = loadCurrentStudentId(this)
        currentStudentName = loadCurrentStudentName(this)
        student_header.init(currentStudentName, currentStudentId)
        loadEvents()

    }

    private fun loadEvents() {
        val call = client.getStaffEventsByStudentId(6114567)
        call.enqueue(object: Callback<List<Event>>{
            override fun onFailure(call: Call<List<Event>>, t: Throwable) {
                Toast.makeText(this@SelectEventActivity, t.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Event>>, response: Response<List<Event>>) {
                val events = response.body()
                RecyclerViewSelectEvent.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(context)
                    adapter = EventAdapter(context, events)
                }
            }
        })
    }

    fun onClickSelectEvent(v: View){
        val intent = Intent(this, OrganizeEventActivity::class.java)
        startActivity(intent)
    }
}
