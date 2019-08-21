package com.example.faiq.guest_book.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainURL {
    private Retrofit retrofit = null;


    public API getAPI() {
        String BASE_URL = "http://10.1.1.116/rest_ci/index.php/";

        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(API.class);
    }
}
