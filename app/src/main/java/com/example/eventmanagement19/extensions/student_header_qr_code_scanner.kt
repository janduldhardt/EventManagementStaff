package com.example.eventmanagement19.extensions

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.example.eventmanagement19.R
import kotlinx.android.synthetic.main.student_header_qr_code_scanner.view.*

class student_header_qr_code_scanner : LinearLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        inflate(R.layout.student_header_qr_code_scanner)
//        init()
    }

    private lateinit var row1: String
    private lateinit var row2: String

    fun init(row1Text: String, row2Text : String) {
        this.row1 = row1Text
        this.row2 = row2Text
        renderMenuHeaderTitleView()
    }

    private fun renderMenuHeaderTitleView() {
        tv_student_header_row1.text = row1
        tv_student_header_row2.text = row2
    }
}