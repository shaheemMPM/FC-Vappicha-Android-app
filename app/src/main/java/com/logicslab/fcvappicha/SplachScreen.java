package com.logicslab.fcvappicha;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;


public class SplachScreen extends AppCompatActivity {

//    AnimationDrawable loadingButton;
//    ImageView slide;
    int SPLASH_TIME_OUT = 700;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach_screen);

//        slide = findViewById(R.id.ivScLoading);
//        slide.setBackgroundResource(R.drawable.splashloading);
//        loadingButton = (AnimationDrawable) slide.getBackground();
//        loadingButton.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplachScreen.this, HomeActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);

    }

//    public void loadMyApi(){
//        new LongOperation().execute("");
//    }

//    private class LongOperation extends AsyncTask<String, Void, String> {
//
//        @Override
//        protected String doInBackground(String... params) {
//            OkHttpClient client = new OkHttpClient();
//            String url = "https://shaheemmpm.github.io/dataprovider/";
//            Request request = new Request.Builder().url(url).build();
//            client.newCall(request).enqueue(new Callback() {
//                @Override
//                public void onFailure(Call call, IOException e) {
//                    resJson = "fail1";
//                }
//
//                @Override
//                public void onResponse(Call call, Response response) throws IOException {
//                    if (response.isSuccessful()){
//                        resJson = response.body().string();
//                    }else {
//                        resJson = "fail2";
//                    }
//                }
//            });
//            return resJson;
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//            Intent i = new Intent(SplachScreen.this, HomeActivity.class);
//            i.putExtra("data", result);
//            startActivity(i);
//            finish();
//        }
//
//        @Override
//        protected void onPreExecute() {}
//
//        @Override
//        protected void onProgressUpdate(Void... values) {}
//    }



}
