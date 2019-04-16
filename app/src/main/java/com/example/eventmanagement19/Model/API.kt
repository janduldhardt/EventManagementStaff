package com.example.eventmanagement19.Model

import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface API {
    @GET("/event/getall")
    fun listAllEvents(): Call<List<Event>>


    @GET("/event/getstaffeventsbystudentid")
    fun getStaffEventsByStudentId(@Query("studentId") studentId: Long) : Call<List<Event>>

    @GET("/event/getStaffsByEventId")
    fun getStaffsByEventId(@Query("eventId") studentId: Long) : Call<StaffList>

    @GET("/event/isOrganizer")
    fun getIsOrganizer(@Query("studentId") studentId: Long) : Call<Long>

    @GET("/event/getStudentById")
    fun getStudentById(@Query("studentId") studentId: Long) : Call<Student>

    @POST("/event/addStaff")
    fun addStaff(@Body staff: Staff): Call<Void>

    @GET("/event/GetAttendeeSummaryByEventId")
    fun getAttendeeSummaryByEventId(@Query("eventId") eventId : Long) : Call<AttendeeSummary>


    @GET("/event/checkedInByStaffId")
    fun getCheckedInByStaffId(@Query("qrContent") qrContent: String,
                 @Query("staffId") staffId : Long): Call<Student>

    @GET("/event/getStaffId")
    fun getStaffId(@Query("studentId") studentId: Long,
                 @Query("eventId") eventId: Long): Call<Student>




}

