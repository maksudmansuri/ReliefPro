package com.unique_upgrade.proHeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OTPActivity extends AppCompatActivity {
EditText otp;
Button submit_otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_t_p);
        otp=findViewById(R.id.otp);
        submit_otp=findViewById(R.id.submit_otp);

        submit_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                VerifyOTP();
            }
        });



    }

    private void VerifyOTP() {
        String Otp_text=otp.getText().toString();
        if(Otp_text.equals("0909")){

            getSharedPreferences("ProHeal",MODE_PRIVATE).edit().putString("key","login").commit();
            Intent i=new Intent(OTPActivity.this,MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);


        }
        else{
            Toast.makeText(this, "wrong OTP !!!", Toast.LENGTH_SHORT).show();
        }
    }


}