package com.example.nycschoolschallenge.model;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SchoolApi {

    @GET("resource/s3k6-pzi2.json")
    Call<List<SchoolPojo>> getSchool();

    /*@GET("resource/f9bf-2cp4.json")
    Call<SATScoresPojo> getScores(@Query("school_name") String schoolName);*/

    @GET("resource/f9bf-2cp4.json")
    Call<List<SATScoresPojo>> getAllScores(@Query("school_name") String schoolName);
}
