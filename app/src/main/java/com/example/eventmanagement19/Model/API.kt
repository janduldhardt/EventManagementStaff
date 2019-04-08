package com.example.eventmanagement19.Model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("/event/getall")
    fun listAllEvents(): Call<List<Event>>


    @GET("/event/getstaffeventsbystudentid")
    fun getStaffEventsByStudentId(@Query("studentId") studentId: Long) : Call<List<Event>>

    @GET("/event/getStaffsByEventId")
    fun getStaffsByEventId(@Query("eventId") studentId: Long) : Call<StaffList>



}

