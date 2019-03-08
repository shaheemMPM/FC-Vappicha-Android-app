package com.logicslab.fcvappicha;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TeamActivity extends AppCompatActivity {

    CoordinatorLayout Home;
    TextView teamWiki;
    LinearLayout instagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        teamWiki = findViewById(R.id.tvTeamWiki);
        teamWiki.setClickable(true);
        teamWiki.setMovementMethod(LinkMovementMethod.getInstance());
        String w1 = "<b>Football Club Vappicha </b>";
        String w3 = "Simply known as <b>FC Vappicha</b> is a football club based in <a href=\"http://gectcr.ac.in/\">GEC</a> <a href=\"https://en.wikipedia.org/wiki/Thrissur\">Thrissur</a>, <a href=\"https://en.wikipedia.org/wiki/Kerala\">Kearala<a>, Featuring in <a href=\"https://www.facebook.com/GEC-Soccer-League-750600941719265\">Gec Soccer League</a>.";
        String sourceString = w1+w3;
        teamWiki.setText(Html.fromHtml(sourceString));
        instagram = findViewById(R.id.llInsta);
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.instagram.com/fc_vappicha/");
                Intent in = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(in);
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
        Home = findViewById(R.id.clTeam);
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
