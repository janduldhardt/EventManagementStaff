package com.example.eventmanagement19

import com.example.eventmanagement19.Model.API
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    var client: API

    init {
        val retrofit = Retrofit.Builder()
//                .baseUrl("http://testevent20181121095158.azurewebsites.net")
            .baseUrl("http://uevent.ap-southeast-1.elasticbeanstalk.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        client = retrofit.create(API::class.java)
    }
}



