package com.unique_upgrade.ReliefPro

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.drawerlayout.widget.DrawerLayout
import com.daimajia.slider.library.Animations.DescriptionAnimation
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.BaseSliderView.OnSliderClickListener
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.daimajia.slider.library.Tricks.ViewPagerEx
import com.google.android.material.navigation.NavigationView
import com.unique_upgrade.ReliefPro.MainActivity
import java.util.*

class MainActivity : AppCompatActivity(), OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    private var actionBarDrawerToggle: ActionBarDrawerToggle? = null
     lateinit var  sliderLayout: SliderLayout
    private var cv_disease: CardView? = null
    private var cv_labs: CardView? = null
    private var cv_body_checkup: CardView? = null
    private var cv_childcare: CardView? = null
    private var cv_pharmacy: CardView? = null
    private var cv_history: CardView? = null
    private var cv_corona_consulting: CardView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialize widgets
        Initialize()

        //onClicks
        onClickEvents()

        //Bottom slider
        InitSlider()
    }

    private fun InitSlider() {
       try {
           var Hash_file_maps: HashMap<String, Int>? = null

           Hash_file_maps = HashMap()
           sliderLayout = findViewById(R.id.slider)
           Hash_file_maps[""] = R.drawable.event1
           Hash_file_maps["  "] = R.drawable.event2
           Hash_file_maps["   "] = R.drawable.event3
           Hash_file_maps["    "] = R.drawable.event4
           for (name in Hash_file_maps.keys) {
               val textSliderView = TextSliderView(this@MainActivity)
               textSliderView
                       .description(name)
                       .image(Hash_file_maps!![name]!!)
                       .setScaleType(BaseSliderView.ScaleType.Fit)
                       .setOnSliderClickListener(this)
               textSliderView.bundle(Bundle())
               sliderLayout.addSlider(textSliderView)
           }
           sliderLayout.setPresetTransformer(SliderLayout.Transformer.Tablet)
           sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)
           sliderLayout.setCustomAnimation(DescriptionAnimation())
           sliderLayout.setDuration(5000)
           sliderLayout.addOnPageChangeListener(this)
       }catch (e :Exception){
           e.printStackTrace()
       }

    }

    private fun onClickEvents() {
        cv_disease!!.setOnClickListener {
            val i = Intent(this@MainActivity, DiseaseActivity::class.java)
            startActivity(i)
        }
        cv_labs!!.setOnClickListener {
            val i = Intent(this@MainActivity, LabsActivity::class.java)
            startActivity(i)
        }
        cv_body_checkup!!.setOnClickListener {
            val i = Intent(this@MainActivity, BodyCheckupActivity::class.java)
            startActivity(i)
        }
        cv_childcare!!.setOnClickListener {
            val i = Intent(this@MainActivity, ChildcareActivity::class.java)
            startActivity(i)
        }
        cv_corona_consulting!!.setOnClickListener {
            val i = Intent(this@MainActivity, DiseaseActivity::class.java)
            startActivity(i)
        }
        cv_history!!.setOnClickListener {
            val i = Intent(this@MainActivity, HistoryActivity::class.java)
            startActivity(i)
        }
        cv_pharmacy!!.setOnClickListener {
            val i = Intent(this@MainActivity, PharmacyActivity::class.java)
            startActivity(i)
        }

    }

    private fun Initialize() {
         var drawer: DrawerLayout? = null
         var navigationView: NavigationView? = null

        //cardViews
        cv_disease = findViewById(R.id.cv_disease)
        cv_body_checkup = findViewById(R.id.cv_body_checkup)
        cv_childcare = findViewById(R.id.cv_childcare)
        cv_labs = findViewById(R.id.cv_labs)
        cv_pharmacy = findViewById(R.id.cv_pharmacy)
        cv_history = findViewById(R.id.cv_history)
        cv_corona_consulting = findViewById(R.id.corona_cons)


        //toolbar
        val my_toolbar = findViewById<Toolbar>(R.id.main_page_toolbar)
        setSupportActionBar(my_toolbar)
        Objects.requireNonNull(supportActionBar)!!.setTitle("ReliefPro")
        drawer = findViewById(R.id.drawerLayout)


        //nav view
        navigationView = findViewById(R.id.drawer)
        val hView = navigationView.inflateHeaderView(R.layout.drawer_header)
        val tv_view_profile = hView.findViewById<TextView>(R.id.header_view_profile)
        tv_view_profile.setOnClickListener {
            val profileIntent = Intent(this@MainActivity, ProfileActivity::class.java)
            startActivity(profileIntent)
        }
        navigationView.itemIconTintList=null
        navigationView!!.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_item_fifteen -> {
                    getSharedPreferences("ReliefPro", MODE_PRIVATE).edit().putString("key", "logout").commit()
                    val signOutIntent = Intent(this@MainActivity, LoginActivity::class.java)
                    signOutIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(signOutIntent)
                }
            }
            false
        }

        //toggle
        actionBarDrawerToggle = ActionBarDrawerToggle(this@MainActivity, drawer, my_toolbar, R.string.drawer_open, R.string.drawer_close)
        drawer.addDrawerListener(actionBarDrawerToggle!!)
        actionBarDrawerToggle!!.syncState()
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_menu)
        //  getSupportActionBar().setHomeButtonEnabled(true);
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onSliderClick(slider: BaseSliderView) {}
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
    override fun onPageSelected(position: Int) {}
    override fun onPageScrollStateChanged(state: Int) {}

    ////////////////////////////////////Overriding lifecycle of activity///////////////////////
    override fun onResume() {
        sliderLayout!!.startAutoCycle()
        super.onResume()
    }

    override fun onStop() {
        sliderLayout!!.stopAutoCycle()
        super.onStop()
    }
}