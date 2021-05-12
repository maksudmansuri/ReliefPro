package com.unique_upgrade.ReliefPro

import android.content.Intent
import android.os.Bundle
import android.os.Handler

import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {
    var handler: Handler? = null
    lateinit var runnable: Runnable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        //Thread
        runnable = Runnable { ////login session//////
            CheckuserLogin()
        }
        handler = Handler()
        handler!!.postDelayed(runnable, 2000)
    }

    private fun CheckuserLogin() {
        try {
            val str = getSharedPreferences("ReliefPro", MODE_PRIVATE).getString("key", "")!!
            if (str == "login") {
                val i = Intent(this@SplashScreenActivity, MainActivity::class.java)
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(i)
            } else {
                val i = Intent(this@SplashScreenActivity, LoginActivity::class.java)
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(i)
            }
        } catch (e: Exception) {
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (handler != null && runnable != null) {
            handler!!.removeCallbacks(runnable)
        }
    }
}