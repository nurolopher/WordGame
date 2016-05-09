package com.nurolopher.wordgame;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;


public class WelcomeScreenActivity extends AppCompatActivity {

    private static final long ACTIVITY_START_DELAY_MILLISECONDS = 1500;
    private TextView welcomeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome_screen);
        hide();
        initProperties();
    }

    private void initProperties() {
        welcomeTextView = (TextView) findViewById(R.id.fullscreen_content);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        this.zoomOutWelcomeText();
        this.openDelayedActivity();
    }

    private void openDelayedActivity() {
        (new Handler()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        }, ACTIVITY_START_DELAY_MILLISECONDS);
    }

    private void zoomOutWelcomeText() {
        welcomeTextView.animate().scaleX(0.5f).scaleY(0.5f).setDuration(1000);
    }

    private void hide() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }
}
