package com.example.user.introductionpageandnewspage;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.user.introductionpageandnewspage.fragment.ForumFragment;
import com.example.user.introductionpageandnewspage.fragment.HomeFragment;
import com.example.user.introductionpageandnewspage.fragment.ManageFragment;
import com.example.user.introductionpageandnewspage.fragment.MapFragment;
import com.example.user.introductionpageandnewspage.fragment.NewsFragment;
import com.example.user.introductionpageandnewspage.mission_page.Mission_Page_Activity;

public class Testing extends AppCompatActivity {
    android.support.v7.app.ActionBar actionBar;
    BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.action_home:
                    transaction.replace(R.id.content, new HomeFragment()).commit();
                    actionBar.setCustomView(R.layout.home_page_actionbar_title);
                    return true;
                case R.id.action_forum:
                    transaction.replace(R.id.content, new ForumFragment()).commit();
                    actionBar.setCustomView(R.layout.forum_page_actionbar_title);
                    return true;
                case R.id.action_news:
                    transaction.replace(R.id.content, new NewsFragment()).commit();
                   // actionBar.setCustomView(R.layout.news_page_actionbar_title);
                    return true;
                case R.id.action_map:
                    transaction.replace(R.id.content, new MapFragment()).commit();
                    actionBar.setCustomView(R.layout.map_page_actionbar_title);
                    return true;

                case R.id.action_manager:
                    transaction.replace(R.id.content, new ManageFragment()).commit();
                    actionBar.setCustomView(R.layout.manage_page_actionbar_title);
                    return true;

            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
        navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.action_news);

        actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.news_page_actionbar_title);
        actionBar.setLogo(R.drawable.ic_head_image);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.news_page_actionbar_mission,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mission:
                Intent intent = new Intent(this, Mission_Page_Activity.class);
                startActivity(intent);
                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
