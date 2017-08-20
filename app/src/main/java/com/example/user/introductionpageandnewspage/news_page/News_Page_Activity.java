package com.example.user.introductionpageandnewspage.news_page;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.introductionpageandnewspage.fragment.ForumFragment;
import com.example.user.introductionpageandnewspage.fragment.HomeFragment;
import com.example.user.introductionpageandnewspage.fragment.ManageFragment;
import com.example.user.introductionpageandnewspage.fragment.MapFragment;
import com.example.user.introductionpageandnewspage.mission_page.Mission_Page_Activity;
import com.example.user.introductionpageandnewspage.R;

public class News_Page_Activity extends AppCompatActivity {

    ListView mListView;
    String [] textnews = {"1","2","3"};
    int [] imagenews = {R.drawable.new1,R.drawable.new2,R.drawable.new3};
    String [] texttitle = {"news1","new2","new3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_page);

        mListView = (ListView) findViewById(R.id.listView);

        NewsAdapter myAdapter = new NewsAdapter(News_Page_Activity.this,textnews,imagenews,texttitle);
        mListView.setAdapter(myAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), News_Page_Activity.class);

                switch(position){
                    case 0 :
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                        break;

                    case 1:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.yahoo.com"));
                        break;

                    case 2:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://translate.google.com.hk/"));
                        break;
                }
                startActivity(intent);
            }
        });


        final BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_news);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch(item.getItemId()){
                    case R.id.action_home:
                        transaction.replace(R.id.content, new HomeFragment()).commit();
                        Toast.makeText(News_Page_Activity.this,"Action Home Clicked",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_forum:
                        transaction.replace(R.id.content, new ForumFragment()).commit();
                        Toast.makeText(News_Page_Activity.this,"Action Forum Clicked",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_news:

                        Toast.makeText(News_Page_Activity.this,"Action News Clicked",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.action_map:
                        transaction.replace(R.id.content, new MapFragment()).commit();
                        //Intent menuIntent = new Intent(News_Page_Activity.this, Map_Page_Activity.class);
                        //startActivity(menuIntent);

                        break;

                    case R.id.action_manager:
                        transaction.replace(R.id.content, new ManageFragment()).commit();
                        Toast.makeText(News_Page_Activity.this,"Action Manager Clicked",Toast.LENGTH_SHORT).show();
                        break;

                }
                return true;
            }
        });

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
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
