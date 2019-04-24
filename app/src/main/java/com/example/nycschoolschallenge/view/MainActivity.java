package com.example.nycschoolschallenge.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nycschoolschallenge.R;
import com.example.nycschoolschallenge.model.SATScoresPojo;

import com.example.nycschoolschallenge.model.SchoolPojo;
import com.example.nycschoolschallenge.presenter.CustomAdapter;
import com.example.nycschoolschallenge.presenter.Presenter;
import com.example.nycschoolschallenge.presenter.PresenterContract;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewContract{

    public static RecyclerView recyclerView;
    public static PresenterContract presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        presenter = new Presenter();
        presenter.bindView(this);
        presenter.initializeRetrofit();
        presenter.getSchools();

    }

    /*@Override
    public void populateSchools(SchoolList dataSet) {
        recyclerView.setAdapter(new CustomAdapter(dataSet));
    }*/

    @Override
    public void populateSchools(List<SchoolPojo> dataSet) {
        recyclerView.setAdapter(new CustomAdapter(dataSet));
    }

    @Override
    public void populateScores(List<SATScoresPojo> dataSet) {

    }

    @Override
    public void populateScores(SATScoresPojo dataSet) {

    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show();
    }
}
