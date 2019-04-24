package com.example.nycschoolschallenge.presenter;

import com.example.nycschoolschallenge.view.ViewContract;

public interface PresenterContract {
    void bindView(ViewContract viewContract);
    void initializeRetrofit();
    void getSchools();
    void getAllSATScores(String schoolName);
    void getAllSATScores();
}
