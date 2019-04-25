package com.example.nycschoolschallenge.presenter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nycschoolschallenge.R;
import com.example.nycschoolschallenge.model.SATScoresPojo;

import java.util.List;

public class SATCustomAdapter extends RecyclerView.Adapter<SATCustomAdapter.CustomViewHolder> {

    private List<SATScoresPojo> scoresList;
    private SATScoresPojo schoolScores;

    private Context context;

    public SATCustomAdapter(List<SATScoresPojo> dataSet){this.scoresList = dataSet;}

    public SATCustomAdapter(@NonNull SATScoresPojo dataSet){this.schoolScores = dataSet;}

    public SATCustomAdapter(Context context){this.context = context;}

    @NonNull
    @Override
    public SATCustomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CustomViewHolder(LayoutInflater.from(viewGroup.getContext())
                                    .inflate(R.layout.school_details, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(SATCustomAdapter.CustomViewHolder customViewHolder, int i) {

            customViewHolder.tvDbn.setText("DBN: " + scoresList.get(i).getDbn());
            customViewHolder.tvTakers.setText("Takers: " + scoresList.get(i).getNumOfSatTestTakers());
            customViewHolder.tvReading.setText("Reading: " + scoresList.get(i).getSatCriticalReadingAvgScore());
            customViewHolder.tvMath.setText("Math: " + scoresList.get(i).getSatMathAvgScore());
            customViewHolder.tvWriting.setText("Writing: " + scoresList.get(i).getSatWritingAvgScore());
            customViewHolder.tvName.setText(scoresList.get(i).getSchoolName());

           if(scoresList == null){
               customViewHolder.cardView.setCardBackgroundColor(Color.WHITE);
               customViewHolder.tvError.setVisibility(View.VISIBLE);

           }

    }

    @Override
    public int getItemCount() {
        return scoresList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView tvDbn, tvTakers, tvReading, tvMath, tvWriting, tvName, tvError;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.card_view_details);
            tvDbn = itemView.findViewById(R.id.tv_dbn);
            tvReading = itemView.findViewById(R.id.tv_reading);
            tvTakers = itemView.findViewById(R.id.tv_sat_takers);
            tvMath = itemView.findViewById(R.id.tv_math);
            tvWriting = itemView.findViewById(R.id.tv_writing);
            tvName = itemView.findViewById(R.id.tv_name);

            tvError = itemView.findViewById(R.id.tv_error);
        }
    }
}
