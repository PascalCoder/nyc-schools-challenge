package com.example.nycschoolschallenge.presenter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nycschoolschallenge.R;
import com.example.nycschoolschallenge.model.SATScoresPojo;

import java.util.List;

public class SATCustomAdapter extends RecyclerView.Adapter<SATCustomAdapter.CustomViewHolder> {

    private List<SATScoresPojo> scoresList;
    private SATScoresPojo schoolScores;

    public SATCustomAdapter(List<SATScoresPojo> dataSet){this.scoresList = dataSet;}

    public SATCustomAdapter(@NonNull SATScoresPojo dataSet){this.schoolScores = dataSet;}

    @NonNull
    @Override
    public SATCustomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CustomViewHolder(LayoutInflater.from(viewGroup.getContext())
                                    .inflate(R.layout.school_details, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SATCustomAdapter.CustomViewHolder customViewHolder, int i) {
        customViewHolder.tvDbn.setText(scoresList.get(i).getDbn()); //scoresList.get(i)
        customViewHolder.tvTakers.setText(scoresList.get(i).getNumOfSatTestTakers());
        customViewHolder.tvReading.setText(scoresList.get(i).getSatCriticalReadingAvgScore());
        customViewHolder.tvMath.setText(scoresList.get(i).getSatMathAvgScore());
        customViewHolder.tvWriting.setText(scoresList.get(i).getSatWritingAvgScore());
        customViewHolder.tvName.setText(scoresList.get(i).getSchoolName());
    }

    @Override
    public int getItemCount() {
        return scoresList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{

        TextView tvDbn, tvTakers, tvReading, tvMath, tvWriting, tvName;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDbn = itemView.findViewById(R.id.tv_dbn);
            tvReading = itemView.findViewById(R.id.tv_reading);
            tvTakers = itemView.findViewById(R.id.tv_sat_takers);
            tvMath = itemView.findViewById(R.id.tv_math);
            tvWriting = itemView.findViewById(R.id.tv_writing);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}
