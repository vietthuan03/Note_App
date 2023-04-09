package com.example.mynotesapp.api;

import androidx.appcompat.app.AlertDialog;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit;
//    private static ApiClient instance = null;
//    private static ApiInterface myApi;
//    private static Gson gson = new GsonBuilder().
//            setLenient().create();
//    private static OkHttpClient.Builder builder = new OkHttpClient.Builder();

//    public static synchronized ApiClient getInstance() {
//
//        if (instance == null) {
//            instance = new ApiClient();
//        }
//        return instance;
//    }
//
//    private ApiClient() {
//            Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiInterface.BASE_URL).
//                    addConverterFactory(GsonConverterFactory.create(gson)).build();
//            myApi = retrofit.create(ApiInterface.class);
//
//    }
//
//    public ApiInterface getMyApi() {
//        return myApi;
//    }
public static Retrofit getApiClient() {

    if (retrofit == null) {
        retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    return retrofit;
}

}
