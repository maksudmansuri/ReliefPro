package com.unique_upgrade.proHeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BodyCheckupActivity extends AppCompatActivity {
Button view_vc1,view_vc2,view_vc3,view_vc4;
TextView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_checkup);
        Initialize();

        back=findViewById(R.id.back);
        back.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(BodyCheckupActivity.this,MainActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(i);
                    }
                }
        );
    }


    private void Initialize() {
        view_vc1=findViewById(R.id.btn_view_vc1);
        view_vc2=findViewById(R.id.btn_view_vc2);
        view_vc3=findViewById(R.id.btn_view_vc3);
        view_vc4=findViewById(R.id.btn_view_vc4);

    }
}