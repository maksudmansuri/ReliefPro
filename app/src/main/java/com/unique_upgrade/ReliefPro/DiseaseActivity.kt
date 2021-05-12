package com.unique_upgrade.ReliefPro

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.unique_upgrade.ReliefPro.DiseaseActivity
import com.unique_upgrade.ReliefPro.adapter.DiseaseAdapter
import com.unique_upgrade.ReliefPro.model.DiseaseModel
import java.util.*

class DiseaseActivity : AppCompatActivity() {
    lateinit var rec_disease: RecyclerView
    lateinit var diseaseModelArrayList: ArrayList<DiseaseModel>
    lateinit var back: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disease)
        rec_disease = findViewById(R.id.rec_disease)
        back = findViewById(R.id.back)
        back.setOnClickListener(
                View.OnClickListener {
                    val i = Intent(this@DiseaseActivity, MainActivity::class.java)
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(i)
                }
        )
        diseaseModelArrayList = ArrayList()
        diseaseModelArrayList.add(DiseaseModel("Corona Consulting",
                "Headache,fever,throat pain...", R.drawable.coronaconsulting))
        diseaseModelArrayList.add(DiseaseModel("Sexology",
                "Disease related to sexual organs..", R.drawable.sexology))

        diseaseModelArrayList.add(DiseaseModel("ENT",
                "Disease related to ear,nose and throat..", R.drawable.ent))

        diseaseModelArrayList.add(DiseaseModel("Psychology",
                "Mental problems, diseases..", R.drawable.physco))

        diseaseModelArrayList.add(DiseaseModel("Gynecology",
                "Abnormal behaviour of sexual organs..", R.drawable.gynacicon))

        diseaseModelArrayList.add(DiseaseModel("Stomach & Digestion",
                "Stomach, Digestive problems..", R.drawable.stomatch))

        diseaseModelArrayList.add(DiseaseModel("Dental", "Tooth-ache, Pain in chewing food..", R.drawable.tooth))
        diseaseModelArrayList.add(DiseaseModel("Cardiology", "Abnormality in heart beats..", R.drawable.cardiologyicon))


        val adapter = DiseaseAdapter(this, diseaseModelArrayList!!)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rec_disease.setLayoutManager(linearLayoutManager)
        rec_disease.setAdapter(adapter)
    }
}