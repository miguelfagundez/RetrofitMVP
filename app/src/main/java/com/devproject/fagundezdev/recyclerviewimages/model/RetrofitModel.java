package com.devproject.fagundezdev.recyclerviewimages.model;

import android.util.Log;

import com.devproject.fagundezdev.recyclerviewimages.RetrofitMVP;
import com.devproject.fagundezdev.recyclerviewimages.model.json.Example;
import com.devproject.fagundezdev.recyclerviewimages.model.retrofit.RandomUserService;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 * Class name: RetrofitModel
 * Base model class
 * @author Miguel Fagundez
 * @version 1.0
 * @since January 2020
 * */
public class RetrofitModel implements RetrofitMVP.Model {

    //*******************************
    // Connect with Presenter
    //*******************************
    private RetrofitMVP.Presenter presenter;

    // Retrofit
    private Retrofit retrofit;

    public RetrofitModel(RetrofitMVP.Presenter presenter) {
        this.presenter = presenter;
    }
    //*********************************
    // HERE making the real connection
    //*********************************
    @Override
    public void makeRetrofitConnection(String Url) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(Url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        RandomUserService service = retrofit.create(RandomUserService.class);
        retrofit2.Call<Example> call = service.getFriends();
        call.enqueue(new retrofit2.Callback<Example>() {
            @Override
            public void onResponse(retrofit2.Call<Example> call, retrofit2.Response<Example> response) {
                ArrayList<Friend> listFriends = initFriends(response.body());
                presenter.sendListFriends(listFriends);
            }

            @Override
            public void onFailure(retrofit2.Call<Example> call, Throwable t) {
                presenter.showErrorMessage(t);

            }
        });
    }

    //*********************************************
    // Create this method to initialize my data using only OkHttp library
    // This method is used in both options
    //*********************************************
    private ArrayList<Friend> initFriends(Example list){
        int numberFriends = list.getResults().size();
        Friend friend;
        ArrayList<Friend> friends = new ArrayList<>();

        for (int i = 0; i < numberFriends; i++){
            friend = new Friend(
                    list.getResults().get(i).getName().getFirst(),
                    list.getResults().get(i).getName().getLast(),
                    list.getResults().get(i).getPicture().getLarge());
            friends.add(friend);
        }

        return friends;
    }

    //*********************************
    // Null references for GC
    //*********************************
    public void destroyReference(){
        presenter = null;
    }

}
