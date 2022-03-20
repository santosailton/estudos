package com.c.retrofit.retrofitjson.controller;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {
    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/irrigacao/previsao/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }
}
