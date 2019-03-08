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
import android.widget.Toast;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class PlayersActivity extends AppCompatActivity {

    ImageView sreerag, ramees, anandu, adithya, shabeel, dharmajith, arshad, sudheesh, fayis, rakesh, vyshnav, jayaprakash;
    ImageView Gsreerag, Gramees, Ganandu, Gadithya, Gshabeel, Gdharmajith, Garshad, Gsudheesh, Gfayis, Grakesh, Gvyshnav, Gjayaprakash;
    CoordinatorLayout Home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        connectImageViews();
        setPlayerImage();
        setPlayerGoal();
        cardLongPress();

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
        Home = findViewById(R.id.clPlayers);
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


    public void connectImageViews(){

        sreerag = findViewById(R.id.ivSreerag);
        ramees = findViewById(R.id.ivRamees);
        anandu = findViewById(R.id.ivAnandu);
        adithya = findViewById(R.id.ivAdithya);
        shabeel = findViewById(R.id.ivShabeel);
        dharmajith = findViewById(R.id.ivDharamajith);
        arshad = findViewById(R.id.ivArshad);
        sudheesh = findViewById(R.id.ivSudheesh);
        fayis = findViewById(R.id.ivFayis);
        rakesh = findViewById(R.id.ivRex);
        vyshnav = findViewById(R.id.ivVyshanav);
        jayaprakash = findViewById(R.id.ivJayaprakash);

        Gsreerag = findViewById(R.id.goalsSreerag);
        Gramees = findViewById(R.id.goalsRamees);
        Ganandu = findViewById(R.id.goalsAnandu);
        Gadithya = findViewById(R.id.goalsAdithya);
        Gshabeel = findViewById(R.id.goalsShabeel);
        Gdharmajith = findViewById(R.id.goalsDharmajith);
        Garshad = findViewById(R.id.goalsArshad);
        Gsudheesh = findViewById(R.id.goalsSudheesh);
        Gfayis = findViewById(R.id.goalsFayis);
        Grakesh = findViewById(R.id.goalsRex);
        Gvyshnav = findViewById(R.id.goalsVyshnav);
        Gjayaprakash = findViewById(R.id.goalsJayaprakash);

    }

    public void setPlayerImage(){

        String [] playersImg = {
                "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/players/photos/sreerag.jpg",
                "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/players/photos/ramees.jpg",
                "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/players/photos/anandu.jpg",
                "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/players/photos/adithya.jpg",
                "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/players/photos/shabeel.jpg",
                "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/players/photos/dharmajith.jpg",
                "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/players/photos/arshad.jpg",
                "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/players/photos/sudheesh.jpg",
                "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/players/photos/fayis.jpg",
                "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/players/photos/rex.jpg",
                "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/players/photos/vyshnav.jpg",
                "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/players/photos/jayaprakash.jpg"
        };

        Picasso.get().load(playersImg[0]).placeholder(R.drawable.player).into(sreerag);
        Picasso.get().load(playersImg[1]).placeholder(R.drawable.player).into(ramees);
        Picasso.get().load(playersImg[2]).placeholder(R.drawable.player).into(anandu);
        Picasso.get().load(playersImg[3]).placeholder(R.drawable.player).into(adithya);
        Picasso.get().load(playersImg[4]).placeholder(R.drawable.player).into(shabeel);
        Picasso.get().load(playersImg[5]).placeholder(R.drawable.player).into(dharmajith);
        Picasso.get().load(playersImg[6]).placeholder(R.drawable.player).into(arshad);
        Picasso.get().load(playersImg[7]).placeholder(R.drawable.player).into(sudheesh);
        Picasso.get().load(playersImg[8]).placeholder(R.drawable.player).into(fayis);
        Picasso.get().load(playersImg[9]).placeholder(R.drawable.player).into(rakesh);
        Picasso.get().load(playersImg[10]).placeholder(R.drawable.player).into(vyshnav);
        Picasso.get().load(playersImg[11]).placeholder(R.drawable.player).into(jayaprakash);

    }

    public void setPlayerGoal(){

        String [] goalImg = {
                "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/players/goals/sreerag.png",
                "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/players/goals/ramees.png",
                "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/players/goals/anandu.png",
                "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/players/goals/adithya.png",
                "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/players/goals/shabeel.png",
                "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/players/goals/dharmajith.png",
                "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/players/goals/arshad.png",
                "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/players/goals/sudheesh.png",
                "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/players/goals/fayis.png",
                "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/players/goals/rex.png",
                "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/players/goals/vyshnav.png",
                "https://raw.githubusercontent.com/shaheemMPM/dataprovider/master/players/goals/jayaprakash.png"
        };

        Picasso.get().load(goalImg[0]).memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE).placeholder(R.drawable.goalstemp).into(Gsreerag);
        Picasso.get().load(goalImg[1]).memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE).placeholder(R.drawable.goalstemp).into(Gramees);
        Picasso.get().load(goalImg[2]).memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE).placeholder(R.drawable.goalstemp).into(Ganandu);
        Picasso.get().load(goalImg[3]).memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE).placeholder(R.drawable.goalstemp).into(Gadithya);
        Picasso.get().load(goalImg[4]).memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE).placeholder(R.drawable.goalstemp).into(Gshabeel);
        Picasso.get().load(goalImg[5]).memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE).placeholder(R.drawable.goalstemp).into(Gdharmajith);
        Picasso.get().load(goalImg[6]).memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE).placeholder(R.drawable.goalstemp).into(Garshad);
        Picasso.get().load(goalImg[7]).memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE).placeholder(R.drawable.goalstemp).into(Gsudheesh);
        Picasso.get().load(goalImg[8]).memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE).placeholder(R.drawable.goalstemp).into(Gfayis);
        Picasso.get().load(goalImg[9]).memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE).placeholder(R.drawable.goalstemp).into(Grakesh);
        Picasso.get().load(goalImg[10]).memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE).placeholder(R.drawable.goalstemp).into(Gvyshnav);
        Picasso.get().load(goalImg[11]).memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE).placeholder(R.drawable.goalstemp).into(Gjayaprakash);

    }

    public void cardLongPress(){
        findViewById(R.id.cvSreerag).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(PlayersActivity.this, "SREERAG M", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        findViewById(R.id.cvRamees).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(PlayersActivity.this, "AHMED RAMEES", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        findViewById(R.id.cvAnandu).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(PlayersActivity.this, "ANANDU VAREESH KUMAR", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        findViewById(R.id.cvAdithya).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(PlayersActivity.this, "ADITHYA PRADEEP", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        findViewById(R.id.cvShabeel).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(PlayersActivity.this, "MUHAMMED SHABEEL", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        findViewById(R.id.cvDharmajith).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(PlayersActivity.this, "DHARMAJITH", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        findViewById(R.id.cvArshad).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(PlayersActivity.this, "ARSHAD", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        findViewById(R.id.cvSudheesh).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(PlayersActivity.this, "SUDHEESH M", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        findViewById(R.id.cvFayis).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(PlayersActivity.this, "MOHAMED FAYIS", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        findViewById(R.id.cvRex).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(PlayersActivity.this, "RAKESH", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        findViewById(R.id.cvVyshnav).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(PlayersActivity.this, "VYSHNAV", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        findViewById(R.id.cvJayaprakash).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(PlayersActivity.this, "JAYAPRAKASH", Toast.LENGTH_SHORT).show();
                return false;
            }
        });


    }

}
