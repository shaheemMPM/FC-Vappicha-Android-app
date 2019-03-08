package com.logicslab.fcvappicha;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class FixtureAcitivity extends AppCompatActivity {

    CoordinatorLayout Home;

    RelativeLayout toggleBtn;
    NestedScrollView ourMatches;
    ImageView toggleIcon;

    int tog = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixture_acitivity);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        toggleBtn = findViewById(R.id.rlOurMatchBtn);
        ourMatches = findViewById(R.id.nsvOurMatch);
        toggleIcon = findViewById(R.id.ivToggleIcon);

        final MediaPlayer click = MediaPlayer.create(this, R.raw.click);

        toggleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tog == 0){
                    ourMatches.setVisibility(View.VISIBLE);
                    toggleIcon.setImageResource(R.drawable.ic_eyecrossed);
                    click.start();
                    tog = 1;
                }else {
                    ourMatches.setVisibility(View.GONE);
                    toggleIcon.setImageResource(R.drawable.ic_eye);
                    click.start();
                    tog = 0;
                }
            }
        });

    }

    @Override
    protected void onResume() {
        netWorkSnack();
        super.onResume();
    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void netWorkSnack(){
        Home = findViewById(R.id.clFixture);
        if (!isNetworkAvailable()){
            Snackbar snackbar = Snackbar.make(Home, "No Internet Connection", Snackbar.LENGTH_INDEFINITE)
                    .setDuration(4000)
                    .setAction("TURN ON", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent();
                            intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$DataUsageSummaryActivity"));
                            startActivity(intent);
                        }
                    });
            snackbar.show();
        }
    }

}
