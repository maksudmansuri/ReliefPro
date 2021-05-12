package com.unique_upgrade.ReliefPro

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.unique_upgrade.ReliefPro.LabsActivity
import com.unique_upgrade.ReliefPro.adapter.LabsAdapter
import com.unique_upgrade.ReliefPro.model.LabsModel
import java.util.*

class LabsActivity : AppCompatActivity() {
    lateinit var rec_labs: RecyclerView
    lateinit var labsModelArrayList: ArrayList<LabsModel>
   lateinit var back: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_labs)
        back = findViewById(R.id.back)
        back.setOnClickListener(
                View.OnClickListener {
                    val i = Intent(this@LabsActivity, MainActivity::class.java)
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(i)
                }
        )
        rec_labs = findViewById(R.id.rec_labs)
        labsModelArrayList = ArrayList()
        labsModelArrayList!!.add(LabsModel("Atmiya Pathology Lab", "Subhanpura,vadodara.", "24/7 open", R.drawable.lab1))
        labsModelArrayList!!.add(LabsModel("WePath Laboratory", "Tarsali.", "24/7 open", R.drawable.lab2))
        labsModelArrayList!!.add(LabsModel("Divine Lab", "Aanand.", "Mon-Fri", R.drawable.lab3))
        labsModelArrayList!!.add(LabsModel("Aayu Pathology Lab ", "Vadodara", "Mon-Sat", R.drawable.lab4))
        labsModelArrayList!!.add(LabsModel("Vadodara Clinical Laboratory", "Vadodara.", "Mon-Fri", R.drawable.lab1))
        val labsAdapter = LabsAdapter(this, labsModelArrayList!!)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rec_labs.setLayoutManager(linearLayoutManager)
        rec_labs.setAdapter(labsAdapter)
    }
}