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

import com.unique_upgrade.proHeal.BodyCheckupActivity;
import com.unique_upgrade.proHeal.HospitalsActivity;
import com.unique_upgrade.proHeal.R;
import com.unique_upgrade.proHeal.TestActivity;
import com.unique_upgrade.proHeal.model.DiseaseModel;
import com.unique_upgrade.proHeal.model.LabsModel;

import java.util.ArrayList;

 public class LabsAdapter extends RecyclerView.Adapter<LabsAdapter.Viewholder> {

    private Context context;
    private ArrayList<LabsModel> labsModelArrayList;

    // Constructor
    public LabsAdapter(Context context, ArrayList<LabsModel> labsModelArrayList) {
        this.context = context;
        this.labsModelArrayList = labsModelArrayList;
    }

    @NonNull
    @Override
    public LabsAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.labslist, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final LabsAdapter.Viewholder holder, int position) {

        LabsModel model = labsModelArrayList.get(position);
        holder.tv_lab_name.setText(model.getLab_name());
        holder.tv_lab_location.setText(model.getLab_location());
        holder.tv_lab_schedule.setText(model.getLab_timing());
        holder.lab_img.setImageResource(model.getLab_img());
        holder.view_tests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(holder.view_tests.getContext(), TestActivity.class);
                holder.view_tests.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return labsModelArrayList.size();
    }


    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView lab_img;
        private TextView tv_lab_name, tv_lab_location,tv_lab_schedule;
        private Button view_tests;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            tv_lab_name = itemView.findViewById(R.id.tv_lab_name);
            tv_lab_schedule = itemView.findViewById(R.id.tv_lab_timing);
            tv_lab_location=itemView.findViewById(R.id.tv_lab_location);
            lab_img=itemView.findViewById(R.id.card_lab_img);
            view_tests=itemView.findViewById(R.id.btn_view_hospitals);

        }
    }
}


