package com.unique_upgrade.proHeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.unique_upgrade.proHeal.adapter.DiseaseAdapter;
import com.unique_upgrade.proHeal.model.DiseaseModel;

import java.util.ArrayList;

public class DiseaseActivity extends AppCompatActivity {
private RecyclerView rec_disease;
private ArrayList<DiseaseModel> diseaseModelArrayList;
TextView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);
        rec_disease=findViewById(R.id.rec_disease);


        back=findViewById(R.id.back);
        back.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(DiseaseActivity.this,MainActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(i);
                    }
                }
        );
        diseaseModelArrayList=new ArrayList<>();
        diseaseModelArrayList.add(new DiseaseModel("Corona Consulting",
                "Headache,fever,throat pain...",R.drawable.corona));
        diseaseModelArrayList.add(new DiseaseModel("Gynecology",
                "Abnormal behaviour of sexual organs.." , R.drawable.gynacology));
        diseaseModelArrayList.add(new DiseaseModel("Dental", "Tooth-ache, Pain in chewing food..", R.drawable.tooth));
        diseaseModelArrayList.add(new DiseaseModel("Cardiology", "Abnormality in heart beats..", R.drawable.cardiology));

        DiseaseAdapter adapter = new DiseaseAdapter(this, diseaseModelArrayList);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);


        rec_disease.setLayoutManager(linearLayoutManager);
        rec_disease.setAdapter(adapter);

    }
}