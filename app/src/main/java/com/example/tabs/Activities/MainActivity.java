package com.example.tabs.Activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.tabs.Adapter.PagerAdapter;
import com.example.tabs.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar((androidx.appcompat.widget.Toolbar) findViewById(R.id.myToolbar));

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        //Se añaden los tabs
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));


        final ViewPager viewPager = findViewById(R.id.viewPager);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adapter);

        //listener para cada vez que se cambie
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        //Cuando se cambie de un tab a otro
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            //Cuando se selecciona el tab
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            //Cuando se sale de un tab
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            //Cuando se vuelve a un tab
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}