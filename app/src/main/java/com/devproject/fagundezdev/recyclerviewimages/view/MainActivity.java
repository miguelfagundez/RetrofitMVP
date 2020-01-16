package com.devproject.fagundezdev.recyclerviewimages.view;

import android.os.Bundle;

import com.devproject.fagundezdev.recyclerviewimages.RetrofitMVP;
import com.devproject.fagundezdev.recyclerviewimages.model.Friend;
import com.devproject.fagundezdev.recyclerviewimages.R;
import com.devproject.fagundezdev.recyclerviewimages.model.retrofit.RandomUserService;
import com.devproject.fagundezdev.recyclerviewimages.model.json.Example;
import com.devproject.fagundezdev.recyclerviewimages.presenter.RetrofitPresenter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;

/*
* Class name: MainActivity
* Base view class
* @author Miguel Fagundez
* @version 1.0
* @since January 2020
* */
public class MainActivity extends AppCompatActivity implements RetrofitMVP.View {

    //*******************************
    // Connect with Presenter
    //*******************************
    private RetrofitMVP.Presenter presenter = null;

    // Base URL for testing
    // Retrofit option
    private static final String URL_TAG = "https://randomuser.me";
    private static final String TAG = "MainActivity_onResponse";

    // Members
    private RecyclerView rvFriends;
    private FriendAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Feature no implemented yet!",Toast.LENGTH_SHORT).show();
            }
        });

        // Creating a presenter
        presenter = new RetrofitPresenter(this);

        //*****************
        // Retrofit option
        //*****************
        connectWithRetrofit(URL_TAG);

        ArrayList<Friend> friends = new ArrayList<>(0);

        rvFriends = findViewById(R.id.recyclerId);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        rvFriends.setLayoutManager(manager);
        adapter = new FriendAdapter(friends);
        rvFriends.setAdapter(adapter);
    }

    //*****************
    // Retrofit option
    //*****************
    //*********************************
    // Requesting a connection
    //*********************************
    public void connectWithRetrofit(String Url) {
        presenter.connectWithRetrofit(Url);
    }

    //*********************************
    // Updating the view
    //*********************************
    @Override
    public void updateListFriends(ArrayList<Friend> listFriends) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.updateFriends(listFriends);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showThisErrorMessage(Throwable t) {
        Log.d(TAG, "Error making a call to retrieve some friends..");
        t.printStackTrace();
    }

    //*********************************
    // Destroy references
    //*********************************
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroyReference();
    }


}
