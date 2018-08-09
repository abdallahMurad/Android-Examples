package com.am.framework.activity;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.am.framework.R;
import com.am.framework.utill.GlideApp;
import com.binaryfork.spanny.Spanny;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.am.framework.utill.CONST.DUMMY_IMG_URL;

public class ManyImageViewsActivity extends BaseActivity {
    @BindView(R.id.imgframe)
    FrameLayout frameLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_many_image_views);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        showBackArrow();

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int sst = width - 20;


        ImageView firstIV = new ImageView(this);
        firstIV.setPadding(0, 5, 0, 0);
        firstIV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        firstIV.setLayoutParams(new FrameLayout.LayoutParams(width / 2, 400));

        ImageView secondIV = new ImageView(this);
        secondIV.setX(width / 2);
        secondIV.setPadding(5, 5, 0, 0);
        secondIV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        secondIV.setLayoutParams(new FrameLayout.LayoutParams(width / 2, 200));

        ImageView thirdIV = new ImageView(this);
        thirdIV.setX(width / 2);
        thirdIV.setY(200);
        thirdIV.setPadding(5, 5, 0, 0);
        thirdIV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        thirdIV.setLayoutParams(new FrameLayout.LayoutParams(width / 2, 200));
        frameLayout.addView(firstIV);
        frameLayout.addView(secondIV);
        frameLayout.addView(thirdIV);
        GlideApp.with(this).load(DUMMY_IMG_URL).diskCacheStrategy(DiskCacheStrategy.ALL).into(firstIV);
        GlideApp.with(this).load(DUMMY_IMG_URL).diskCacheStrategy(DiskCacheStrategy.ALL).into(secondIV);
        GlideApp.with(this).load(DUMMY_IMG_URL).diskCacheStrategy(DiskCacheStrategy.ALL).into(thirdIV);
        TextView textView = new TextView(this);
        int extraImagesCount = 3;
        Spanny spanny = new Spanny("+ " + extraImagesCount, new ForegroundColorSpan(Color.BLACK));
        textView.setText(spanny);
        textView.setX(sst / 2 - 30);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setY(400 / 3 + 400 / 4);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(40);
        textView.setLayoutParams(new FrameLayout.LayoutParams(sst / 2, 400 / 3));

        frameLayout.addView(textView);

    }

}