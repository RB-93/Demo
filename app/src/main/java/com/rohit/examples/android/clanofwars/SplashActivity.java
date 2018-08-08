package com.rohit.examples.android.clanofwars;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class SplashActivity extends AppCompatActivity {

    public ImageView splashImage;
    public ConstraintLayout constraintLayout;

    public ProgressBar progressBar;

    private int progressStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.hide();
        }
        setContentView(R.layout.activity_splash);

        splashImage = findViewById(R.id.imageView);



        final LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        final View rl = inflater.inflate(R.layout.activity_main,null);
        final View cv = inflater.inflate(R.layout.activity_main, null);

        final RelativeLayout relativeLayout;
        final CardView cardView;
        relativeLayout = rl.findViewById(R.id.splash_rl);

        cardView = cv.findViewById(R.id.card_splash);

        progressBar = findViewById(R.id.progressBar_splash);

        progressBar.setVisibility(View.GONE);

        Animation fade = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fade.setDuration(1000);
        splashImage.startAnimation(fade);

        progressBar.setVisibility(View.VISIBLE);

        final Handler handler = new Handler();
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 1;
                    // Update the progress bar and display the
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        Thread.sleep(20);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        int SPLASH_TIME_OUT = 2500;
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent intentMain = new Intent(SplashActivity.this, MainActivity.class);
                if(intentMain.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentMain);
                }
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
