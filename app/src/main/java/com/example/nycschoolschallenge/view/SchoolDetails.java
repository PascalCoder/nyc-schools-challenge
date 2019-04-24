package com.example.nycschoolschallenge.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.nycschoolschallenge.R;
import com.example.nycschoolschallenge.model.SATScoresPojo;
import com.example.nycschoolschallenge.model.SchoolPojo;
import com.example.nycschoolschallenge.presenter.Presenter;
import com.example.nycschoolschallenge.presenter.SATCustomAdapter;

import java.util.List;

public class SchoolDetails extends AppCompatActivity implements ViewContract{

    public RecyclerView scoresRecyclerView;
    public static Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_details);

        scoresRecyclerView = findViewById(R.id.recycler_view_sat);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        scoresRecyclerView.setLayoutManager(gridLayoutManager);

        String schoolName = getIntent().getStringExtra("schoolName");

        presenter = new Presenter();
        presenter.bindView(this);
        presenter.initializeRetrofit();

        presenter.getAllSATScores(schoolName);


        Toast.makeText(this, "" + schoolName, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void populateSchools(List<SchoolPojo> dataSet) {

    }

    @Override
    public void populateScores(List<SATScoresPojo> dataSet) {
        scoresRecyclerView.setAdapter(new SATCustomAdapter(dataSet));
    }

    @Override
    public void populateScores(SATScoresPojo dataSet) {
        scoresRecyclerView.setAdapter(new SATCustomAdapter(dataSet));
    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show();
    }
}
