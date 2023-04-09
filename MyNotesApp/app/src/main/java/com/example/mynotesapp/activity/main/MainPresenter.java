package com.example.mynotesapp.activity.main;

import androidx.annotation.NonNull;

import com.example.mynotesapp.api.ApiClient;
import com.example.mynotesapp.api.ApiInterface;
import com.example.mynotesapp.model.Note;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {

    MainView view;

    public MainPresenter(MainView mainView) {
        this.view = mainView;
    }

    void getData(){
        view.showLoading();
        ApiInterface apiInterface = ApiClient.getApiClient()
                .create(ApiInterface.class);

        Call<List<Note>> call = apiInterface.getNotes();
        call.enqueue(new Callback<List<Note>>() {
            @Override
            public void onResponse(@NonNull Call<List<Note>> call, @NonNull Response<List<Note>> response) {
                view.hideLoading();
                if(response.isSuccessful() && response.body() !=null ){
                    view.onGetResult(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Note>> call, @NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }

}
