package com.imagiobox.interviewdemo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.imagiobox.interviewdemo.Api.ApiResponse;
import com.imagiobox.interviewdemo.R;

public class UserProfileActivity extends AppCompatActivity {

    ImageView ivBack, ivProfile;
    TextView tvName, tvLocation, tvBio;
    ApiResponse apiResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        apiResponse = ApiResponse.getInstance();

        ivBack = findViewById(R.id.iv_back);
        ivProfile = findViewById(R.id.iv_profile);
        tvName = findViewById(R.id.tv_name);
        tvLocation = findViewById(R.id.tv_location);
        tvBio = findViewById(R.id.tv_bio);

        int pos = getIntent().getIntExtra("selectedpos", 0);

        if (!apiResponse.getMyResponseList().isEmpty()) {
            RequestOptions requestOptions = new RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .skipMemoryCache(true)
                    .centerCrop()
                    .dontAnimate()
                    .dontTransform()
                    .placeholder(R.color.placeholder_bg)
                    .priority(Priority.IMMEDIATE)
                    .encodeFormat(Bitmap.CompressFormat.PNG)
                    .format(DecodeFormat.DEFAULT);

            Glide.with(UserProfileActivity.this)
                    .applyDefaultRequestOptions(requestOptions)
                    .load(apiResponse.getMyResponseList().get(pos).getUser().getProfileImage().getLarge())
                    .thumbnail(0.25f)
                    .into(ivProfile);

            if (apiResponse.getMyResponseList().get(pos).getUser().getUsername() != null) {
                tvName.setText(apiResponse.getMyResponseList().get(pos).getUser().getUsername());
            } else {
                tvName.setText("N/A");
            }
            if (apiResponse.getMyResponseList().get(pos).getUser().getLocation() != null) {
                tvLocation.setText(apiResponse.getMyResponseList().get(pos).getUser().getLocation());
            } else {
                tvLocation.setText("N/A");
            }

            if (apiResponse.getMyResponseList().get(pos).getUser().getBio() != null) {
                tvBio.setText(apiResponse.getMyResponseList().get(pos).getUser().getBio());
            } else {
                tvBio.setText("N/A");
            }

        }

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}