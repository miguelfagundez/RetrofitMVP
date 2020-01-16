package com.devproject.fagundezdev.recyclerviewimages.presenter;

import com.devproject.fagundezdev.recyclerviewimages.RetrofitMVP;
import com.devproject.fagundezdev.recyclerviewimages.model.Friend;
import com.devproject.fagundezdev.recyclerviewimages.model.RetrofitModel;

import java.util.ArrayList;

/*
 * Class name: RetrofitPresenter
 * Base presenter class
 * @author Miguel Fagundez
 * @version 1.0
 * @since January 2020
 * */
public class RetrofitPresenter implements RetrofitMVP.Presenter {

    //*******************************
    // Connect with View and Model
    //*******************************
    private RetrofitMVP.View view;
    private RetrofitMVP.Model model;

    // Constructor
    public RetrofitPresenter(RetrofitMVP.View view) {
        this.view = view;
        model = new RetrofitModel(this);
    }

    //*********************************
    // Requesting a connection
    //*********************************
    @Override
    public void connectWithRetrofit(String Url) {
        model.makeRetrofitConnection(Url);
    }

    //*********************************
    // Receiving a List from Model to View
    //*********************************
    @Override
    public void sendListFriends(ArrayList<Friend> listFriends) {
        view.updateListFriends(listFriends);
    }

    @Override
    public void showErrorMessage(Throwable t) {
        view.showThisErrorMessage(t);
    }

    //*********************************
    // Null references for GC
    //*********************************
    public void destroyReference(){
        model.destroyReference();
        view = null;
        model = null;
    }
}
