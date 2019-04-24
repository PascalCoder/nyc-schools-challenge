package com.example.nycschoolschallenge.presenter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nycschoolschallenge.R;
import com.example.nycschoolschallenge.model.SATScoresPojo;
import com.example.nycschoolschallenge.model.SchoolPojo;
import com.example.nycschoolschallenge.view.SchoolDetails;

import java.util.List;



public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private static String TAG = "CustomerAdapter";

    private static List<SchoolPojo> schools;


    private SchoolPojo schoolPojo;


    public CustomAdapter(@NonNull List<SchoolPojo> dataSet){this.schools = dataSet;}


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CustomViewHolder(LayoutInflater.from(viewGroup.getContext())
                                    .inflate(R.layout.item_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {

        customViewHolder.tvSchoolName.setText(schools.get(i).getSchoolName());
        customViewHolder.tvAcademic1.setText(schools.get(i).getAcademicOpportunities1());
        customViewHolder.tvAcademic2.setText(schools.get(i).getAcademicOpportunities2());
        customViewHolder.tvPriority11.setText(schools.get(i).getAdmissionsPriority11());

        if(i == 0){ customViewHolder.ivArrowLeft.setVisibility(View.GONE); }

        if(i == schools.size()-1){ customViewHolder.ivArrowRight.setVisibility(View.GONE); }

    }

    @Override
    public int getItemCount() {
        return schools.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView ivArrowLeft, ivArrowRight;
        TextView tvSchoolName, tvAcademic1, tvAcademic2, tvPriority11;

        public CustomViewHolder(@NonNull View itemView) {

            super(itemView);

            cardView = itemView.findViewById(R.id.card_view);
            ivArrowLeft = itemView.findViewById(R.id.iv_arrow_left);
            ivArrowRight = itemView.findViewById(R.id.iv_arrow_right);
            tvSchoolName = itemView.findViewById(R.id.tv_school_name);
            tvAcademic1 = itemView.findViewById(R.id.tv_academic1);
            tvAcademic2 = itemView.findViewById(R.id.tv_academic2);
            tvPriority11 = itemView.findViewById(R.id.tv_priority11);


            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    schoolPojo = new SchoolPojo(tvSchoolName.getText().toString(), tvAcademic1.getText().toString(),
                            tvAcademic2.getText().toString(), tvPriority11.getText().toString());

                    Log.d(TAG, "onClick: " + schoolPojo.getSchoolName());

                    //Toast.makeText(v.getContext(), "" + schoolPojo.getSchoolName(), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent();
                    intent.setClass(v.getContext(), SchoolDetails.class);
                    intent.putExtra("schoolName", schoolPojo.getSchoolName());

                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
