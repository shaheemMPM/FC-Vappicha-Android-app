package com.logicslab.fcvappicha;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.LinearLayout;

public class AboutActivity extends AppCompatActivity {

    CoordinatorLayout Home;
    CardView developer;
    LinearLayout share, rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        developer = findViewById(R.id.cvDeveloper);
        developer.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/shaheemMPM"));
                startActivity(browserIntent);
                return true;
            }
        });
        share = findViewById(R.id.llShare);
        rate = findViewById(R.id.llRate);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dialogue = "FC Vappicha\n\nFC Vappicha is a football team playing under the Gec Soccer League(GSL)\n" +
                        "The club app allows you to get our regular updates, live scores, fixtures and results. Be a part of this wonderful brotherhood and, support us while we take our baby steps towards the beautiful game.\n\nhttps://play.google.com/store/apps/details?id=com.logicslab.fcvappicha";
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Share the App");
                intent.putExtra(Intent.EXTRA_TEXT, dialogue);
                startActivity(Intent.createChooser(intent, "Share Via"));
            }
        });
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
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
        Home = findViewById(R.id.clAbout);
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
