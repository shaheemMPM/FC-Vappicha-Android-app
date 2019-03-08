package com.logicslab.fcvappicha;

import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;


public class HomeActivity extends AppCompatActivity {

    ViewFlipper flipper;
    Button fixture, matches, players, scoreboard, about, team;
    CoordinatorLayout Home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        buttonNavigate();
        netWorkSnack();
        autoSlide();
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
        Home = findViewById(R.id.clHome);
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

    public static int dpToPx(long dp)
    {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public  void buttonNavigate(){
        final int idTeam = R.id.btnHaTeam;
        final int idFixture = R.id.btnHaFixture;
        final int idMatches = R.id.btnHaMatches;
        final int idPlayers = R.id.btnHaPlayers;
        final int idScoreboard = R.id.btnHaScoreboard;
        final int idAbout = R.id.btnHaAbout;

        team = findViewById(idTeam);
        fixture = findViewById(idFixture);
        matches = findViewById(idMatches);
        players = findViewById(idPlayers);
        scoreboard = findViewById(idScoreboard);
        about = findViewById(idAbout);

        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics ();
        display.getMetrics(outMetrics);

        float density  = getResources().getDisplayMetrics().density;
        float dpWidth  = outMetrics.widthPixels / density;
        dpWidth = (dpWidth - 30)/2;
        long Huse = Math.round(dpWidth*1.11);
        long Wuse = Math.round(dpWidth);
        int needHeight = dpToPx(Huse);
        int needWidth = dpToPx(Wuse);

        team.setLayoutParams(new LinearLayout.LayoutParams(needWidth, needHeight));
        fixture.setLayoutParams(new LinearLayout.LayoutParams(needWidth, needHeight));
        matches.setLayoutParams(new LinearLayout.LayoutParams(needWidth, needHeight));
        players.setLayoutParams(new LinearLayout.LayoutParams(needWidth, needHeight));
        scoreboard.setLayoutParams(new LinearLayout.LayoutParams(needWidth, needHeight));
        about.setLayoutParams(new LinearLayout.LayoutParams(needWidth, needHeight));

        final MediaPlayer click = MediaPlayer.create(this, R.raw.click);

        team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.start();
                Intent teamIntent = new Intent(HomeActivity.this, TeamActivity.class);
                startActivity(teamIntent);
            }
        });

        fixture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.start();
                Intent fixtureIntent = new Intent(HomeActivity.this, FixtureAcitivity.class);
                startActivity(fixtureIntent);
            }
        });

        matches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.start();
                Intent matchesIntent = new Intent(HomeActivity.this, MactchesActivity.class);
                startActivity(matchesIntent);
            }
        });

        players.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.start();
                Intent playersIntent = new Intent(HomeActivity.this, PlayersActivity.class);
                startActivity(playersIntent);
            }
        });

        scoreboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.start();
                Intent scoreboardIntent = new Intent(HomeActivity.this, ScoreboardActivity.class);
                startActivity(scoreboardIntent);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.start();
                Intent aboutIntent = new Intent(HomeActivity.this, AboutActivity.class);
                startActivity(aboutIntent);
            }
        });


    }

    public void autoSlide(){
        String images[] = {
                "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/slides/slide1.jpg",
                "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/slides/slide2.jpg",
                "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/slides/slide3.jpg",
                "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/slides/slide4.jpg"
        };

        flipper = findViewById(R.id.vfHaSlider);

        for (String image: images){
            flipperImages(image);
        }
    }

    public void flipperImages(String image){
        ImageView slideImage = new ImageView(this);
        slideImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Picasso.get().load(image).memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE).placeholder(R.drawable.vfc).into(slideImage);

        flipper.addView(slideImage);
        flipper.setFlipInterval(4000);
        flipper.setAutoStart(true);

        flipper.setInAnimation(this, android.R.anim.slide_in_left);
        flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }

}
