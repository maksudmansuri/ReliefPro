package com.unique_upgrade.ReliefPro

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.unique_upgrade.ReliefPro.BodyCheckupActivity

class BodyCheckupActivity : AppCompatActivity() {
    var view_vc1: Button? = null
    var view_vc2: Button? = null
    var view_vc3: Button? = null
    var view_vc4: Button? = null
    lateinit var back: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_body_checkup)
        Initialize()
        back = findViewById(R.id.back)
        back.setOnClickListener(
                View.OnClickListener {
                    val i = Intent(this@BodyCheckupActivity, MainActivity::class.java)
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(i)
                }
        )
    }

    private fun Initialize() {
        view_vc1 = findViewById(R.id.btn_view_vc1)
        view_vc2 = findViewById(R.id.btn_view_vc2)
        view_vc3 = findViewById(R.id.btn_view_vc3)
        view_vc4 = findViewById(R.id.btn_view_vc4)
    }
}