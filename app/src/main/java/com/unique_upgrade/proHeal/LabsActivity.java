package com.unique_upgrade.proHeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.unique_upgrade.proHeal.adapter.DiseaseAdapter;
import com.unique_upgrade.proHeal.adapter.LabsAdapter;
import com.unique_upgrade.proHeal.model.DiseaseModel;
import com.unique_upgrade.proHeal.model.LabsModel;

import java.util.ArrayList;

public class LabsActivity extends AppCompatActivity {
    private RecyclerView rec_labs;
    private ArrayList<LabsModel> labsModelArrayList;
    TextView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labs);



        back=findViewById(R.id.back);
        back.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(LabsActivity.this,MainActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(i);
                    }
                }
        );



        rec_labs=findViewById(R.id.rec_labs);

        labsModelArrayList=new ArrayList<>();
        labsModelArrayList.add(new LabsModel("Atmiya Pathology Lab","Subhanpura,vadodara.","24/7 open",R.drawable.lab1));
        labsModelArrayList.add(new LabsModel("WePath Laboratory","Tarsali.","24/7 open",R.drawable.lab2));
        labsModelArrayList.add(new LabsModel("Divine Lab","Aanand.","Mon-Fri",R.drawable.lab3));
        labsModelArrayList.add(new LabsModel("Aayu Pathology Lab ","Vadodara","Mon-Sat",R.drawable.lab4));
        labsModelArrayList.add(new LabsModel("Vadodara Clinical Laboratory","Vadodara.","Mon-Fri",R.drawable.lab1));

        LabsAdapter labsAdapter = new LabsAdapter(this, labsModelArrayList);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rec_labs.setLayoutManager(linearLayoutManager);
        rec_labs.setAdapter(labsAdapter);
    }
}