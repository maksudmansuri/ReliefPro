package com.unique_upgrade.ReliefPro

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.unique_upgrade.ReliefPro.LoginActivity

class LoginActivity : AppCompatActivity() {
    lateinit var signup: Button
    lateinit var login: Button
    lateinit var mobile_login: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        signup = findViewById(R.id.signup_btn)
        login = findViewById(R.id.login_btn)
        mobile_login = findViewById(R.id.mobile_login)
        mobile_login.setOnClickListener(View.OnClickListener {
            val i = Intent(this@LoginActivity, OTPActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(i)
        })
        signup.setOnClickListener(View.OnClickListener {
            val i = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(i)
        })
        login.setOnClickListener(View.OnClickListener { Toast.makeText(this@LoginActivity, "Use given OTP to Login", Toast.LENGTH_LONG).show() })
    }
}