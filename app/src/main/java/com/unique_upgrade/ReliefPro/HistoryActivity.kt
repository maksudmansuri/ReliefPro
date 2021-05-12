package com.unique_upgrade.ReliefPro

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.unique_upgrade.ReliefPro.HistoryActivity

class HistoryActivity : AppCompatActivity() {
    lateinit var back: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        back = findViewById(R.id.back)
        back.setOnClickListener(
                View.OnClickListener {
                    val i = Intent(this@HistoryActivity, MainActivity::class.java)
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(i)
                }
        )
    }
}