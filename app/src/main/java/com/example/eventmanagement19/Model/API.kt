package com.example.eventmanagement19.Model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("/event/getall")
    fun listAllEvents(): Call<List<Event>>

    @GET("/event/getTodayEvents")
    fun getTodayEvents(@Query("studentId") studentId: String) : Call<List<Event>>

    @GET("/event/getTodayEvents")
    fun getStaffEventsByStudentId(@Query("studentId") studentId: String) : Call<List<Event>>



}

