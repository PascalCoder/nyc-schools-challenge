package com.example.nycschoolschallenge.view;

import com.example.nycschoolschallenge.model.SATScoresPojo;
import com.example.nycschoolschallenge.model.SchoolList;
import com.example.nycschoolschallenge.model.SchoolPojo;

import java.util.List;

public interface ViewContract {

    void populateSchools(List<SchoolPojo> dataSet);
    void populateScores(List<SATScoresPojo> dataSet);
    void populateScores(SATScoresPojo dataSet);
    void onError(String errorMessage);
}
