package com.example.eventmanagement19

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.example.eventmanagement19.extensions.inflate
import kotlinx.android.synthetic.main.student_header.view.*

class student_header : LinearLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        inflate(R.layout.student_header)
//        init()
    }

    private lateinit var name: String
    private lateinit var school: String

    fun init(name: String, school : String) {
        this.name = name
        this.school = school
        renderMenuHeaderTitleView()
    }

    private fun renderMenuHeaderTitleView() {
        tv_student_header_row1.text = name
        tv_student_header_row2.text = school
    }
}