package com.logicslab.fcvappicha;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class ScoreboardActivity extends AppCompatActivity {

    CoordinatorLayout Home;
    ImageView scoreboard, status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        scoreboard = findViewById(R.id.ivScoreboard);
        status = findViewById(R.id.ivStatus);
        String urlSb = "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/scoreboard/scorboard.png";
        String urlSt = "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/scoreboard/status.png";
        Picasso.get().load(urlSb).memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE).placeholder(R.drawable.sbtemp).into(scoreboard);
        Picasso.get().load(urlSt).memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE).placeholder(R.drawable.sttemp).into(status);
    }

    @Override
    protected void onResume() {
        netWorkSnack();
        super.onResume();
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void netWorkSnack(){
        Home = findViewById(R.id.clScoreBoard);
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


