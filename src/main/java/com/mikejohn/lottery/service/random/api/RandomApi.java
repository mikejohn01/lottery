package com.mikejohn.lottery.service.random.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RandomApi {
    @GET("/integers/")
    Call<Integer> getRandom(
            @Query("num") int num,
            @Query("min") int min,
            @Query("max") int max,
            @Query("col") int col,
            @Query("base") int base,
            @Query("format") String format,
            @Query("rnd") String rnd
    );
}
