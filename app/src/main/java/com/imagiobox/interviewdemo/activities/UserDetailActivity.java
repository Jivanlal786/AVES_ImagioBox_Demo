package com.imagiobox.interviewdemo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.imagiobox.interviewdemo.Api.ApiResponse;
import com.imagiobox.interviewdemo.R;

public class UserDetailActivity extends AppCompatActivity {

    ImageView ivBack, ivPhoto;
    TextView tvDescription;
    ApiResponse apiResponse;
    String TAG = "JJJJJ_UserDeatil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        apiResponse = ApiResponse.getInstance();

        ivBack = findViewById(R.id.iv_back);
        ivPhoto = findViewById(R.id.iv_photo);
        tvDescription = findViewById(R.id.tv_desc);

        Log.e(TAG, "onCreate: " + apiResponse.getMyResponseList());

        int pos = getIntent().getIntExtra("selectedpos", 0);

        if (apiResponse.getMyResponseList().size() > 0) {
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

            Glide.with(UserDetailActivity.this)
                    .applyDefaultRequestOptions(requestOptions)
                    .load(apiResponse.getMyResponseList().get(pos).getUrls().getFull())
                    .thumbnail(0.25f)
                    .into(ivPhoto);

            if (apiResponse.getMyResponseList().get(pos).getDescription() != null) {
                tvDescription.setText(apiResponse.getMyResponseList().get(pos).getDescription());
            } else if (apiResponse.getMyResponseList().get(pos).getAltDescription() != null) {
                tvDescription.setText(apiResponse.getMyResponseList().get(pos).getAltDescription());
            } else {
                tvDescription.setText("");
            }
        } else {
            Toast.makeText(this, "List is empty", Toast.LENGTH_SHORT).show();
        }

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}