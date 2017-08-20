package com.example.user.introductionpageandnewspage.introduction_page;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.user.introductionpageandnewspage.Testing;
import com.example.user.introductionpageandnewspage.news_page.News_Page_Activity;
import com.example.user.introductionpageandnewspage.R;

import java.util.Timer;
import java.util.TimerTask;

public class Introduction_Page_Activity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
            getSupportActionBar().hide();
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

            setContentView(R.layout.introduction_page);


            Timer timer = new Timer();
            timer.schedule(new TimerTask() {

                public void run() {
                    startActivity(new Intent(Introduction_Page_Activity.this, Testing.class));
                    finish();
                }
            }, 1000);
        }
}
