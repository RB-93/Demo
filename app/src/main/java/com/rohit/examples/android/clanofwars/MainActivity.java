package com.rohit.examples.android.clanofwars;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    public Button rule_btn;
    public Button play_btn;
    public Button back_btn;

    public CardView cardView;
    public CardView cardView_rules;

    public RelativeLayout relativeLayout;
    public ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.hide();
        }
        setContentView(R.layout.activity_main);

        relativeLayout = findViewById(R.id.splash_rl);

        cardView = findViewById(R.id.card_splash);
        relativeLayout = findViewById(R.id.splash_rl);
        rule_btn = findViewById(R.id.rule_button);
        play_btn = findViewById(R.id.play_button);

        viewMaker();

        rule_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Animation buttonSlideRight = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.play_btn_slideout);

                constraintLayout = findViewById(R.id.cl);
                final LayoutInflater inflate_ruleCard = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                final RelativeLayout rule_relativeLayout = (RelativeLayout) inflate_ruleCard
                        .inflate(R.layout.activity_rules, null);
                //Handler handler = new Handler();

                cardView_rules = findViewById(R.id.card_rules);

                Animation slideOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.card_slideout_bottom);
                cardView.startAnimation(slideOut);
                cardView.setVisibility(View.GONE);

                relativeLayout.removeView(relativeLayout);
                relativeLayout.removeAllViews();

                relativeLayout.setBackgroundResource(R.drawable.splash_bg);

                relativeLayout.addView(rule_relativeLayout);
                Animation rule_slideIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.card_slidein_top);
                rule_relativeLayout.startAnimation(rule_slideIn);

                back_btn = findViewById(R.id.btn_back);
                back_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        if(intent.resolveActivity(getPackageManager()) != null)  {
                            startActivity(intent);
                        }
                        finish();
                    }

                });
                //play_btn.startAnimation(buttonSlideRight);
                //rule_btn.setVisibility(View.INVISIBLE);
            }
        });

        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent playIntent = new Intent(MainActivity.this, PlayerChooserActivity.class);
                if (playIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(playIntent);
                }
            }
        });
    }

    public void viewMaker() {

        cardView.setVisibility(View.GONE);
        rule_btn.setVisibility(View.GONE);
        play_btn.setVisibility(View.GONE);

        Animation card_slideIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.card_slidein_top);
        Animation buttonSlideRight = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rule_btn_slidein);
        Animation buttonSlideLeft = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.play_btn_slidein);

        if(cardView.getVisibility() == View.GONE) {
            cardView.setVisibility(View.VISIBLE);
            cardView.startAnimation(card_slideIn);
        }

        if(rule_btn.getVisibility() == View.GONE || play_btn.getVisibility() == View.GONE) {
            rule_btn.setVisibility(View.VISIBLE);
            play_btn.setVisibility(View.VISIBLE);
            rule_btn.startAnimation(buttonSlideRight);
            play_btn.startAnimation(buttonSlideLeft);
        }
    }
}
