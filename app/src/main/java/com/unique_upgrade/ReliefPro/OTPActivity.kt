package com.unique_upgrade.ReliefPro

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.unique_upgrade.ReliefPro.OTPActivity

class OTPActivity : AppCompatActivity() {
    var otp: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_o_t_p)
        var submit_otp: Button? = null
        otp = findViewById(R.id.otp)
        submit_otp = findViewById(R.id.submit_otp)
        submit_otp.setOnClickListener(View.OnClickListener { VerifyOTP() })
    }

    private fun VerifyOTP() {
        val Otp_text = otp!!.text.toString()
        if (Otp_text == "0909") {
            getSharedPreferences("ReliefPro", MODE_PRIVATE).edit().putString("key", "login").commit()
            val i = Intent(this@OTPActivity, MainActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(i)
        } else {
            Toast.makeText(this, "wrong OTP !!!", Toast.LENGTH_SHORT).show()
        }
    }
}