package com.devproject.fagundezdev.recyclerviewimages;


import com.devproject.fagundezdev.recyclerviewimages.model.Friend;

import java.util.ArrayList;

import retrofit2.http.Url;

/*
 * Interface name: RetrofitMVP
 * Base interface for implementing MVP design architecture
 * @author Miguel Fagundez
 * @version 1.0
 * @since January 2020
 * */
public interface RetrofitMVP {

    interface View{
        void updateListFriends(ArrayList<Friend> listFriends);
        void showThisErrorMessage(Throwable t);
    }

    interface Presenter{
        void connectWithRetrofit(String Url);
        void destroyReference();
        void sendListFriends(ArrayList<Friend> listFriends);
        void showErrorMessage(Throwable t);
    }

    interface Model{
        void makeRetrofitConnection(String Url);
        void destroyReference();
    }
}
