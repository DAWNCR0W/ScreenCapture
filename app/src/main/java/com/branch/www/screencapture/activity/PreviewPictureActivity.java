package com.branch.www.screencapture.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;

import com.branch.www.screencapture.GlobalScreenShot;
import com.branch.www.screencapture.R;
import com.branch.www.screencapture.ScreenCaptureApplication;

/**
 *
 */
public class PreviewPictureActivity extends FragmentActivity implements GlobalScreenShot.onScreenShotListener {

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, PreviewPictureActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }

    private ImageView mPreviewImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_preview_layout);
        mPreviewImageView = (ImageView) findViewById(R.id.preview_image);

        GlobalScreenShot screenshot = new GlobalScreenShot(getApplicationContext());

        Bitmap bitmap = ((ScreenCaptureApplication) getApplication()).getmScreenCaptureBitmap();

        mPreviewImageView.setImageBitmap(bitmap);
        mPreviewImageView.setVisibility(View.GONE);

        if (bitmap != null) {
            screenshot.takeScreenshot(bitmap, this);
        }

    }

    @Override
    public void onStartShot() {

    }

    @Override
    public void onFinishShot(boolean success) {
        mPreviewImageView.setVisibility(View.VISIBLE);
    }
}