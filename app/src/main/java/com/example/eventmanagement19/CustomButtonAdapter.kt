import CustomButtonAdapter.ViewHolder
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.example.eventmanagement19.CustomButton
import com.example.eventmanagement19.R
import kotlinx.android.synthetic.main.custom_button.view.image_custom_button
import kotlinx.android.synthetic.main.custom_button.view.text_custom_button

class CustomButtonAdapter(private val context: Context, val inputList: List<CustomButton>?) :
    RecyclerView.Adapter<ViewHolder>() {


    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.custom_button, p0, false)
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
        p0.view.image_custom_button.setImageResource(item.mImageResource)
        p0.view.text_custom_button.text = item.buttonText

        p0.itemView.setOnClickListener {
            if(p0.view.text_custom_button.text == "Event Management"){
                Toast.makeText(context, "Event Management", Toast.LENGTH_SHORT).show()
            }

        }
    }
}