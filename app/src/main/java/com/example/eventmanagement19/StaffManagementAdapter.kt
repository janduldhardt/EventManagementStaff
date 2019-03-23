package com.example.eventmanagement19

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eventmanagement19.Model.CustomButton
import com.example.eventmanagement19.Model.StaffManagementItem
import com.example.eventmanagement19.StaffManagementAdapter.ViewHolder
import kotlinx.android.synthetic.main.custom_button.view.image_custom_button
import kotlinx.android.synthetic.main.custom_button.view.text_custom_button
import kotlinx.android.synthetic.main.staff_management_item.view.text_count_staffManagement_item
import kotlinx.android.synthetic.main.staff_management_item.view.text_studentId_staffManagement_item
import kotlinx.android.synthetic.main.staff_management_item.view.text_studentName_staffManagement_item

class StaffManagementAdapter(private val context: Context, private val inputList: List<StaffManagementItem>, private val callback : (StaffManagementItem) -> Unit) :
    RecyclerView.Adapter<ViewHolder>() {


    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.staff_management_item, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (inputList != null) {
            return inputList.size
        }
        return 0
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        var item = inputList!!.get(p1)
        p0.view.text_studentId_staffManagement_item.text = item.studentId
        p0.view.text_studentName_staffManagement_item.text = item.studentName
        p0.view.text_count_staffManagement_item.text = item.count.toString()


        p0.itemView.setOnClickListener {
            callback(item)
        }
    }
}