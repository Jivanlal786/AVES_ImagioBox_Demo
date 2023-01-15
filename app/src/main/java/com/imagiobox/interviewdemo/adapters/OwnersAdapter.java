package com.imagiobox.interviewdemo.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.imagiobox.interviewdemo.R;
import com.imagiobox.interviewdemo.activities.UserDetailActivity;
import com.imagiobox.interviewdemo.activities.UserProfileActivity;
import com.imagiobox.interviewdemo.model.MyResponse;

import java.util.ArrayList;

public class OwnersAdapter extends RecyclerView.Adapter<OwnersAdapter.MyOwnerHolder> {

    Context activity;
    ArrayList<MyResponse> userList;
    String TAG = "JJJJJJ_OwnerAdap";

    public void setUserList(ArrayList<MyResponse> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    public OwnersAdapter(Context activity, ArrayList<MyResponse> userList) {
        this.activity = activity;
        this.userList = userList;
    }

    @NonNull
    @Override
    public MyOwnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.owner_adapter, parent, false);
        return new MyOwnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOwnerHolder holder, @SuppressLint("RecyclerView") int position) {

        Glide.with(activity)
                .load(userList.get(position).getUrls().getRegular())
                .into(holder.ivPhoto);

        if (userList.get(position).getDescription() != null) {
            holder.tvDescription.setText(userList.get(position).getDescription());
        } else if (userList.get(position).getAltDescription() != null) {
            holder.tvDescription.setText(userList.get(position).getAltDescription());
        } else {
            holder.tvDescription.setText("");
            holder.tvDescription.setVisibility(View.GONE);
        }

        Glide.with(activity)
                .load(userList.get(position).getUser().getProfileImage().getMedium())
                .thumbnail(0.25f)
                .into(holder.ivProfile);

        holder.tvOwnerName.setText(userList.get(position).getUser().getUsername());

        holder.ivPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, UserProfileActivity.class);
                intent.putExtra("selectedpos",position);
                activity.startActivity(intent);
            }
        });
        holder.tvOwnerName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, UserDetailActivity.class);
                intent.putExtra("selectedpos",position);
                activity.startActivity(intent);
            }
        });
        holder.ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, UserDetailActivity.class);
                intent.putExtra("selectedpos",position);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class MyOwnerHolder extends RecyclerView.ViewHolder {

        ImageView ivProfile, ivPhoto;
        TextView tvDescription, tvOwnerName;

        public MyOwnerHolder(@NonNull View itemView) {
            super(itemView);

            ivPhoto = itemView.findViewById(R.id.iv_photo);
            ivProfile = itemView.findViewById(R.id.iv_profile);
            tvDescription = itemView.findViewById(R.id.tv_desc);
            tvOwnerName = itemView.findViewById(R.id.tv_username);
        }
    }
}
