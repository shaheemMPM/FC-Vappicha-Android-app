package com.logicslab.fcvappicha;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;


public class MactchesActivity extends AppCompatActivity {

    CoordinatorLayout Home;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    private String tt;
    String [] collectionData;

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mactches);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        loadData();
        updateView(tt);
        refresh();
    }

    public void refresh(){
        new doit().execute();
    }

    public class doit extends AsyncTask<Void, Void, Void>{
        String words;

        @Override
        protected Void doInBackground(Void... voids) {

            try {

                Document doc = Jsoup.connect("https://shaheemmpm.github.io/dataprovider/").get();
                words = doc.text();

            }catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (isNetworkAvailable()){
                saveData(words);
            }
            loadData();
            updateView(tt);
        }
    }

    public void saveData(String temp){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TEXT, temp);
        editor.apply();
        Toast.makeText(this, "Data Reloaded", Toast.LENGTH_SHORT).show();
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        tt = sharedPreferences.getString(TEXT, "");
    }

    public void updateView(String words){
        int flag=0;
        if (words.length() < 3){
            flag = 1;
        }
        if (flag == 0){
            String matchDetails[] = words.split("_");
            int noMatches = matchDetails.length;
            ArrayList<String> matchesArrayList = new ArrayList<>();
            for (String copy: matchDetails){
                String tempMatch[] = copy.split("#");
                matchesArrayList.addAll(Arrays.asList(tempMatch));
            }
            int count = matchesArrayList.size();

            ArrayList<Integer> firstLogoAL = new ArrayList<>();
            ArrayList<Integer> secondLogoAL = new ArrayList<>();
            ArrayList<String> firstTeamAL = new ArrayList<>();
            ArrayList<String> firstGoalsAL = new ArrayList<>();
            ArrayList<String> secondTeamAL = new ArrayList<>();
            ArrayList<String> secondGoalsAL = new ArrayList<>();
            ArrayList<String> matchdayAL = new ArrayList<>();

            collectionData = matchesArrayList.toArray(new String[count]);

            for (int i=0; i<collectionData.length; i+=5){
                int teamId = Integer.parseInt(collectionData[i]);
                String teamName;
                int tempLogo;
                switch (teamId){
                    case 1: {
                        teamName = "FC Vappicha";
                        tempLogo = R.drawable.fcvappicha;
                        break;
                    }
                    case 2: {
                        teamName = "Alkulth FC";
                        tempLogo = R.drawable.alkulth;
                        break;
                    }
                    case 3: {
                        teamName = "Barricade FC";
                        tempLogo = R.drawable.barricade;
                        break;
                    }
                    case 4: {
                        teamName = "Bekache FC";
                        tempLogo = R.drawable.bekache;
                        break;
                    }
                    case 5: {
                        teamName = "Brocode FC";
                        tempLogo = R.drawable.brocode;
                        break;
                    }
                    case 6: {
                        teamName = "FC Yakuza";
                        tempLogo = R.drawable.fcyakuza;
                        break;
                    }
                    case 7: {
                        teamName = "Kandam FC";
                        tempLogo = R.drawable.kandamrunners;
                        break;
                    }
                    case 8: {
                        teamName = "Sporting FC";
                        tempLogo = R.drawable.sporting;
                        break;
                    }
                    default: {
                        teamName = "No Matches";
                        tempLogo = R.drawable.goalstemp;
                    }
                }
                Integer tempInteger = tempLogo;
                firstLogoAL.add(tempInteger);
                firstTeamAL.add(teamName);
            }
            for (int i=1; i<collectionData.length; i+=5){
                firstGoalsAL.add(collectionData[i]);
            }
            for (int i=2; i<collectionData.length; i+=5){
                int teamId = Integer.parseInt(collectionData[i]);
                String teamName;
                int tempLogo;
                switch (teamId){
                    case 1: {
                        teamName = "FC Vappicha";
                        tempLogo = R.drawable.fcvappicha;
                        break;
                    }
                    case 2: {
                        teamName = "Alkulth FC";
                        tempLogo = R.drawable.alkulth;
                        break;
                    }
                    case 3: {
                        teamName = "Barricade FC";
                        tempLogo = R.drawable.barricade;
                        break;
                    }
                    case 4: {
                        teamName = "Bekache FC";
                        tempLogo = R.drawable.bekache;
                        break;
                    }
                    case 5: {
                        teamName = "Brocode FC";
                        tempLogo = R.drawable.brocode;
                        break;
                    }
                    case 6: {
                        teamName = "FC Yakuza";
                        tempLogo = R.drawable.fcyakuza;
                        break;
                    }
                    case 7: {
                        teamName = "Kandam FC";
                        tempLogo = R.drawable.kandamrunners;
                        break;
                    }
                    case 8: {
                        teamName = "Sporting FC";
                        tempLogo = R.drawable.sporting;
                        break;
                    }
                    default: {
                        teamName = "No Matches";
                        tempLogo = R.drawable.goalstemp;
                    }
                }
                Integer tempInteger = tempLogo;
                secondLogoAL.add(tempInteger);
                secondTeamAL.add(teamName);
            }
            for (int i=3; i<collectionData.length; i+=5){
                secondGoalsAL.add(collectionData[i]);
            }
            for (int i=4; i<collectionData.length; i+=5){
                SimpleDateFormat format1 = new SimpleDateFormat("ddMMyyyy", Locale.getDefault());
                SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
                Date date;
                String toAdd="";
                try{
                    date = format1.parse(collectionData[i]);
                    toAdd = format2.format(date);
                }
                catch (ParseException e){
                    e.printStackTrace();
                }
                matchdayAL.add(toAdd);
            }

            ArrayList<ExampleItem> exampleList = new ArrayList<>();




            for (int i=0; i<noMatches; i++){
                exampleList.add(new ExampleItem(firstLogoAL.get(i), secondLogoAL.get(i), firstTeamAL.get(i), secondTeamAL.get(i), firstGoalsAL.get(i), secondGoalsAL.get(i), matchdayAL.get(i)));
            }

            mRecyclerView = findViewById(R.id.rvMatches);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(this);
            mAdapter = new ExampleAdapter(exampleList);
            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(mAdapter);
        }
    }


    @Override
    protected void onResume() {
        netWorkSnack();
        refresh();
        super.onResume();
    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void netWorkSnack(){
        Home = findViewById(R.id.clMatches);
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