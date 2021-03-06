package com.example.nycschoolschallenge.presenter;

import android.util.Log;
import android.widget.Toast;

import com.example.nycschoolschallenge.model.SATScoresPojo;
import com.example.nycschoolschallenge.model.SchoolApi;
import com.example.nycschoolschallenge.model.SchoolList;
import com.example.nycschoolschallenge.model.SchoolPojo;
import com.example.nycschoolschallenge.view.ViewContract;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Presenter implements PresenterContract {

    private static final String TAG = Presenter.class.getSimpleName();

    ViewContract viewContract;
    SchoolApi api;

    /*public static SATScoresPojo satScoresPojo;
    public static List<SATScoresPojo> satScoresList;*/

    @Override
    public void bindView(ViewContract viewContract) {
        this.viewContract = viewContract;
    }

    @Override
    public void initializeRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://data.cityofnewyork.us/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(SchoolApi.class);
    }

    @Override
    public void getSchools() {

        api.getSchool().enqueue(new Callback<List<SchoolPojo>>() {
            @Override
            public void onResponse(Call<List<SchoolPojo>> call, Response<List<SchoolPojo>> response) {
                viewContract.populateSchools((response.body()));
            }

            @Override
            public void onFailure(Call<List<SchoolPojo>> call, Throwable t) {
                viewContract.onError(t.getMessage());
            }
        });

    }

    @Override
    public void getAllSATScores() {

    }

    @Override
    public void getAllSATScores(String schoolName) {

        api.getAllScores(schoolName.toUpperCase() ).enqueue(new Callback<List<SATScoresPojo>>() {
            @Override
            public void onResponse(Call<List<SATScoresPojo>> call, Response<List<SATScoresPojo>> response) {
                viewContract.populateScores(response.body());
                //satScoresList = new ArrayList<>(response.body());
                Log.d(TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<List<SATScoresPojo>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

}
