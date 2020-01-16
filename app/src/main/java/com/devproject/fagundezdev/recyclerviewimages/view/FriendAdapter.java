package com.devproject.fagundezdev.recyclerviewimages.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.devproject.fagundezdev.recyclerviewimages.model.Friend;
import com.devproject.fagundezdev.recyclerviewimages.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
 * Class name: FriendAdapter
 * Basic adapter class extending from RecyclerView.Adapter
 * Having access to the view using custom ViewHolder
 * @author Miguel Fagundez
 * @version 1.0
 * @since January 2020
 * */
public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder> {

    // Members for having access to the data
    private ArrayList<Friend> myFriendList;

    // Constructor
    public FriendAdapter(ArrayList<Friend> myFriendList) {
        this.myFriendList = myFriendList;
    }

    public void updateFriends(ArrayList<Friend> myFriends){
        myFriendList = myFriends;
        notifyDataSetChanged();
    }
    // I inflate the layout and return a holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Taking the context from the parent and inflate the friend layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend,parent,false);

        // Create a new ViewHolder and return it
        return new ViewHolder(view);
    }

    // Using the Holder, I have access to the data
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Friend friend = myFriendList.get(position);
        holder.name.setText(friend.getfName() + " " + friend.getlName());
        // Using Picasso for managing the url
        Picasso.get().load(friend.getUrl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return myFriendList == null ? 0 : myFriendList.size();
    }

    // Provide a direct reference to the views
    public static class ViewHolder extends RecyclerView.ViewHolder{

        // Every component of the view
        public final TextView name;
        public final ImageView image;

        // ViewHolder constructor
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.name = itemView.findViewById(R.id.tvName);
            this.image = itemView.findViewById(R.id.ivImage);
        }
    }
}
