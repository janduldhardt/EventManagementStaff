package com.example.eventmanagement19

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.widget.LinearLayout
import com.example.eventmanagement19.extensions.inflate
import kotlinx.android.synthetic.main.custom_button_attendee_summary.view.*

class custom_button_attendee_summary : ConstraintLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        inflate(R.layout.custom_button_attendee_summary)
//        init()
    }



    private lateinit var shirtSize: String
    private lateinit var count: String
    private lateinit var labelInfo : String


    fun initShirtSize( shirtSize: String = "", count : String) {
        this.shirtSize = shirtSize
        this.count = count
        this.labelInfo = "Size"
        renderMenuHeaderTitleView()
    }

    fun initFoodType(labelInfo: String , count : String) {
        this.shirtSize = ""
        this.count = count
        this.labelInfo = labelInfo
        renderMenuHeaderTitleView()
    }

    private fun renderMenuHeaderTitleView() {
        custom_button_shirt_size.text = shirtSize
        custom_button_count.text = count
        custom_button_labelInfo.text = labelInfo
    }
}
