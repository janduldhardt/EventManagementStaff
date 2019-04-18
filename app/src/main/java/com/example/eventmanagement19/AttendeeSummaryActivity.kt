package com.example.eventmanagement19

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.eventmanagement19.Model.AttendeeSummary
import com.example.eventmanagement19.extensions.*
import kotlinx.android.synthetic.main.activity_attendee_summary.*
import kotlinx.android.synthetic.main.event_item_view.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AttendeeSummaryActivity : AppCompatActivity() {


    lateinit var currentStudentName: String
    lateinit var currentStudentId: String
    lateinit var currentEventId: String
    lateinit var currentEventName: String
    lateinit var currentOrganizerId: String
    lateinit var currentEventImageUrl: String




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendee_summary)
        currentEventId = loadCurrentEventId(this)
        loadVars()
        student_header.init(currentEventName, "Attendee Summary")
        loadData()


    }

    private fun loadData() {
        val call = RetrofitService().client.getAttendeeSummaryByEventId(currentEventId.toLong())
        call.enqueue(object : Callback<AttendeeSummary>{
            override fun onFailure(call: Call<AttendeeSummary>, t: Throwable) {
                Toast.makeText(this@AttendeeSummaryActivity, t.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<AttendeeSummary>,
                response: Response<AttendeeSummary>
            ) {
                val summary = response.body()

                summary?.let { refreshLayout(it) }


            }
        })


    }

    private fun refreshLayout(attendeeSummary: AttendeeSummary) {
        text_attendeeCapacity.text = attendeeSummary.capacity.toString()
        text_attendeeCount.text = attendeeSummary.enrolledNumber.toString()

        attendee_shirtS.initShirtSize("S", attendeeSummary.shirtSize.s.toString())
        attendee_shirtM.initShirtSize("M", attendeeSummary.shirtSize.m.toString() )
        attendee_shirtL.initShirtSize("L", attendeeSummary.shirtSize.l.toString() )
        attendee_shirtXL.initShirtSize("XL", attendeeSummary.shirtSize.xl.toString() )
        attendee_shirtXXL.initShirtSize("XXL", attendeeSummary.shirtSize.xxl.toString() )
        attendee_shirt3XL.initShirtSize("3XL", attendeeSummary.shirtSize.xxxl.toString() )

        attendee_food_normal.initFoodType("Normal", attendeeSummary.foodType.normal.toString())
        attendee_food_islam.initFoodType("Islam", attendeeSummary.foodType.islam.toString())
        attendee_food_noEggs.initFoodType("No Eggs", attendeeSummary.foodType.noEggs.toString())
        attendee_food_noMilk.initFoodType("No Milk", attendeeSummary.foodType.noMilk.toString())
        attendee_food_noWheat.initFoodType("No Wheat", attendeeSummary.foodType.noWheat.toString())
        attendee_food_vegetarian.initFoodType("Vegetarian", attendeeSummary.foodType.vegetarian.toString())
        attendee_food_noSpicy.initFoodType("No Spicy", attendeeSummary.foodType.noSpicy.toString())
        attendee_food_noPeanuts.initFoodType("No Peanuts", attendeeSummary.foodType.noPeanuts.toString())
        attendee_food_noShellfish.initFoodType("No Shellfish", attendeeSummary.foodType.nOShellfish.toString())
        attendee_food_other.initFoodType("Other", attendeeSummary.foodType.other.toString())


        val options = RequestOptions()
        options.centerCrop()
        Glide.with(this@AttendeeSummaryActivity)
            .load(currentEventImageUrl)
            .apply(options)
            .into(image_attendee_summary)
    }

    private fun loadVars() {
        currentStudentId = loadCurrentStudentId(this)
        currentStudentName = loadCurrentStudentName(this)
        currentEventId = loadCurrentEventId(this)
        currentEventName = loadCurrentEventName(this)
        currentOrganizerId = loadCurrentOrganizerId(this)
        currentEventImageUrl = loadCurrentEventImageUrl(this)

    }
}
