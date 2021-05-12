package com.unique_upgrade.ReliefPro.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.unique_upgrade.ReliefPro.R
import com.unique_upgrade.ReliefPro.TestActivity
import com.unique_upgrade.ReliefPro.model.LabsModel
import java.util.*

class LabsAdapter     // Constructor
(private val context: Context, private val labsModelArrayList: ArrayList<LabsModel>) : RecyclerView.Adapter<LabsAdapter.Viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.labslist, parent, false)
        return Viewholder(view)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val model = labsModelArrayList[position]
        holder.tv_lab_name.text = model.lab_name
        holder.tv_lab_location.text = model.lab_location
        holder.tv_lab_schedule.text = model.lab_timing
        holder.lab_img.setImageResource(model.lab_img)
        holder.view_tests.setOnClickListener {
            val i = Intent(holder.view_tests.context, TestActivity::class.java)
            holder.view_tests.context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return labsModelArrayList.size
    }

    inner class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val lab_img: ImageView
        val tv_lab_name: TextView
        val tv_lab_location: TextView
        val tv_lab_schedule: TextView
        val view_tests: Button

        init {
            tv_lab_name = itemView.findViewById(R.id.tv_lab_name)
            tv_lab_schedule = itemView.findViewById(R.id.tv_lab_timing)
            tv_lab_location = itemView.findViewById(R.id.tv_lab_location)
            lab_img = itemView.findViewById(R.id.card_lab_img)
            view_tests = itemView.findViewById(R.id.btn_view_hospitals)
        }
    }
}