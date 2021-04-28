package com.unique_upgrade.proHeal.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.unique_upgrade.proHeal.HospitalsActivity;
import com.unique_upgrade.proHeal.R;
import com.unique_upgrade.proHeal.model.DiseaseModel;

import java.util.ArrayList;

public class DiseaseAdapter extends RecyclerView.Adapter<DiseaseAdapter.Viewholder> {

    private Context context;
    private ArrayList<DiseaseModel> diseaseModelArrayList;

    // Constructor
    public DiseaseAdapter(Context context, ArrayList<DiseaseModel> diseaseModelArrayList) {
        this.context = context;
        this.diseaseModelArrayList = diseaseModelArrayList;
    }

    @NonNull
    @Override
    public DiseaseAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.diseaselist, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final DiseaseAdapter.Viewholder holder, int position) {

        DiseaseModel model = diseaseModelArrayList.get(position);
        holder.tv_disease_name.setText(model.getDisease_name());
        holder.tv_disease_symptoms.setText(model.getDisease_symptoms());
        holder.disease_img.setImageResource(model.getDisease_img());
        holder.view_hs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(holder.view_hs.getContext(),HospitalsActivity.class);
                holder.view_hs.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return diseaseModelArrayList.size();
    }


    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView disease_img;
        private Button view_hs;
        private TextView tv_disease_name, tv_disease_symptoms;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            tv_disease_name = itemView.findViewById(R.id.tv_disease_name);
            tv_disease_symptoms = itemView.findViewById(R.id.tv_disease_schedule);
            disease_img=itemView.findViewById(R.id.card_disease_img);
            view_hs=itemView.findViewById(R.id.btn_view_hospitals);
        }
    }
}

