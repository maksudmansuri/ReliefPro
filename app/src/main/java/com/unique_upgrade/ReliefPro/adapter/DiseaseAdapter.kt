package com.unique_upgrade.ReliefPro.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.unique_upgrade.ReliefPro.HospitalsActivity
import com.unique_upgrade.ReliefPro.R
import com.unique_upgrade.ReliefPro.model.DiseaseModel
import de.hdodenhof.circleimageview.CircleImageView
import java.util.*

class DiseaseAdapter     // Constructor
(private val context: Context, private val diseaseModelArrayList: ArrayList<DiseaseModel>) : RecyclerView.Adapter<DiseaseAdapter.Viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.diseaselist, parent, false)
        return Viewholder(view)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val model = diseaseModelArrayList[position]
        holder.tv_disease_name.text = model.disease_name
        holder.tv_disease_symptoms.text = model.disease_symptoms
        holder.disease_img.setImageResource(model.disease_img)
        holder.view_hs.setOnClickListener {
            val i = Intent(holder.view_hs.context, HospitalsActivity::class.java)
            holder.view_hs.context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return diseaseModelArrayList.size
    }

    inner class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val disease_img: CircleImageView
        val view_hs: Button
        val tv_disease_name: TextView
        val tv_disease_symptoms: TextView

        init {
            tv_disease_name = itemView.findViewById(R.id.tv_disease_name)
            tv_disease_symptoms = itemView.findViewById(R.id.tv_disease_schedule)
            disease_img = itemView.findViewById(R.id.card_disease_img)
            view_hs = itemView.findViewById(R.id.btn_view_hospitals)
        }
    }
}