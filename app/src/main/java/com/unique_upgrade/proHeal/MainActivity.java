package com.unique_upgrade.proHeal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;

import android.os.Bundle;


import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.google.android.material.navigation.NavigationView;

import java.util.HashMap;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawer;
   private NavigationView navigationView;

   private CardView cv_disease,cv_labs,cv_body_checkup,cv_childcare,cv_pharmacy,cv_history,cv_corona_consulting;
    SliderLayout sliderLayout;
    HashMap<String,Integer> Hash_file_maps ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize widgets
        Initialize();

      //onClicks
        onClickEvents();

       //Bottom slider
       InitSlider();


    }

    private void InitSlider() {
        Hash_file_maps =new HashMap<>();

        sliderLayout = findViewById(R.id.slider);
        Hash_file_maps.put("Proviiding All kind of Tests in Pandamic.\n\n\n", R.drawable.lab1);
        Hash_file_maps.put("Labs are working for you 24/7..\n\n\n", R.drawable.lab2);
        Hash_file_maps.put("Your safety is our first priority.\n\n\n", R.drawable.lab3);
        Hash_file_maps.put("Latest news and updates on Medicines and Covid Tests..\n\n\n", R.drawable.lab4);

        for(String name : Hash_file_maps.keySet()){

            TextSliderView textSliderView = new TextSliderView(MainActivity.this);
            textSliderView
                    .description(name)
                    .image(Hash_file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener((this));
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Tablet);
        //   sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Top);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(5000);
        sliderLayout.addOnPageChangeListener(this);

    }

    private void onClickEvents() {


        cv_disease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,DiseaseActivity.class);
                startActivity(i);
            }
        });
        cv_labs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,LabsActivity.class);
                startActivity(i);
            }
        });
        cv_body_checkup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,BodyCheckupActivity.class);
                startActivity(i);
            }
        });
        cv_childcare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ChildcareActivity.class);
                startActivity(i);
            }
        });
        cv_corona_consulting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,DiseaseActivity.class);
                startActivity(i);
            }
        });
        cv_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,HistoryActivity.class);
                startActivity(i);
            }
        });
        cv_pharmacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,PharmacyActivity.class);
                startActivity(i);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_item_one:
                    Intent profileIntent=new Intent(MainActivity.this,ProfileActivity.class);
                    startActivity(profileIntent);
                        break;
                    case R.id.nav_item_fifteen:
                        getSharedPreferences("ProHeal",MODE_PRIVATE).edit().putString("key","logout").commit();
                        Intent signOutIntent=new Intent(MainActivity.this,LoginActivity.class);
                        signOutIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(signOutIntent);
                        break;

                }

                return false;
            }
        });

    }

    private void Initialize() {
        //cardViews
        cv_disease=findViewById(R.id.cv_disease);
        cv_body_checkup=findViewById(R.id.cv_body_checkup);
        cv_childcare=findViewById(R.id.cv_childcare);
        cv_labs=findViewById(R.id.cv_labs);
        cv_pharmacy=findViewById(R.id.cv_pharmacy);
        cv_history=findViewById(R.id.cv_history);
        cv_corona_consulting=findViewById(R.id.corona_cons);



        //toolbar
      final  androidx.appcompat.widget.Toolbar my_toolbar=findViewById(R.id.main_page_toolbar);
        setSupportActionBar(my_toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("ProHeal");

        drawer= findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.drawer);
        navigationView.setItemIconTintList(null);

        //toggle
        actionBarDrawerToggle=new ActionBarDrawerToggle(MainActivity.this,drawer,my_toolbar
                ,R.string.drawer_open,R.string.drawer_close);
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
     //  getSupportActionBar().setHomeButtonEnabled(true);


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    ////////////////////////////////////Overriding lifecycle of activity///////////////////////

    @Override
    protected void onResume() {

        sliderLayout.startAutoCycle();
        super.onResume();
    }
    @Override
    protected void onStop() {

        sliderLayout.stopAutoCycle();

        super.onStop();
    }


}