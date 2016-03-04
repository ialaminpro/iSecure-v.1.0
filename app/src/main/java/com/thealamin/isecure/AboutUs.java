package com.thealamin.isecure;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Locale;

public class AboutUs extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    Locale myLocale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo); //also displays wide logo
        getSupportActionBar().setDisplayShowTitleEnabled(false); //optional


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        loadLocale();

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();



        if (id == R.id.Emergency_service) {

            Intent refresh = new Intent(this, MainActivity.class);
            startActivity(refresh);
            finish();

        }  else if (id == R.id.Womens_Right) {
            Intent refresh = new Intent(this,WomenRights.class);
            startActivity(refresh);
            finish();

        }else if (id == R.id.Womens_laws) {
            Intent refresh = new Intent(this,WomenLaws.class);
            startActivity(refresh);
            finish();

        } else if (id == R.id.Cyber_laws) {
            Intent refresh = new Intent(this,CyberLaws.class);
            startActivity(refresh);
            finish();


        }
        else if (id == R.id.onAirhelp) {
            Intent refresh = new Intent(this,Call.class);
            startActivity(refresh);
            finish();

        }else if (id == R.id.police) {
            Intent refresh = new Intent(this,Call.class);
            startActivity(refresh);
            finish();

        }else if (id == R.id.Advocate) {
            Intent refresh = new Intent(this,Call.class);
            startActivity(refresh);
            finish();

        }else if (id == R.id.womens_organization) {
            Intent refresh = new Intent(this,WomenOrganization.class);
            startActivity(refresh);
            finish();

        }else if (id == R.id.Ambulance) {
            Intent refresh = new Intent(this,Call.class);
            startActivity(refresh);
            finish();

        }else if (id == R.id.fire_service) {
            Intent refresh = new Intent(this,Call.class);
            startActivity(refresh);
            finish();

        }else if (id == R.id.minster_office) {
            Intent refresh = new Intent(this,Call.class);
            startActivity(refresh);
            finish();

        }else if (id == R.id.media) {
            Intent refresh = new Intent(this,Call.class);
            startActivity(refresh);
            finish();

        }

        else if (id == R.id.Ladies_Toilet) {
            Intent refresh = new Intent(this,LadiesToilet.class);
            startActivity(refresh);
            finish();

        } else if (id == R.id.Danger_Zone) {
            Intent refresh = new Intent(this,LadiesToilet.class);
            startActivity(refresh);
            finish();

        } else if (id == R.id.Police_Station) {
            Intent refresh = new Intent(this,LadiesToilet.class);
            startActivity(refresh);
            finish();

        } else if (id == R.id.Hospital_view) {
            Intent refresh = new Intent(this,LadiesToilet.class);
            startActivity(refresh);
            finish();


        } else if (id == R.id.Womens_Organigation_view) {
            Intent refresh = new Intent(this,LadiesToilet.class);
            startActivity(refresh);
            finish();

        } else if (id == R.id.Court_view) {

            Intent refresh = new Intent(this,LadiesToilet.class);
            startActivity(refresh);
            finish();

        } else if (id == R.id.App_User) {

            Intent refresh = new Intent(this,LadiesToilet.class);
            startActivity(refresh);
            finish();

        } else if (id == R.id.Tools_view) {

            Intent refresh = new Intent(this,ToolView.class);
            startActivity(refresh);
            finish();

        } else if (id == R.id.Community_view) {

            Intent refresh = new Intent(this,Community.class);
            startActivity(refresh);
            finish();

        } else if (id == R.id.Chat_Room) {
            Intent refresh = new Intent(this,ChatRoom.class);
            startActivity(refresh);
            finish();

        } else if (id == R.id.Womens_Organigation_community) {
            Intent refresh = new Intent(this,WomenOrganigationCommunity.class);
            startActivity(refresh);
            finish();

        } else if (id == R.id.We_Can) {

            Intent refresh = new Intent(this,WeCan.class);
            startActivity(refresh);
            finish();
        } else if (id == R.id.Help_Feedback) {
            Intent refresh = new Intent(this,HelpFeedback.class);
            startActivity(refresh);
            finish();

        } else if (id == R.id.About_Us) {
            Intent refresh = new Intent(this,AboutUs.class);
            startActivity(refresh);
            finish();
        }


        else if (id == R.id.language_bangla_select){

            int lang = 1;

            saveLangupreference(lang);



        }
        else if (id == R.id.language_english_select){

            int lang = 0;

            saveLangupreference(lang);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    public void changeLang(String lang)
    {
        if (lang.equalsIgnoreCase(""))
            return;
        myLocale = new Locale(lang);
        saveLocale(lang);
        Locale.setDefault(myLocale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = myLocale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        //  updateTexts();
    }

    public void saveLocale(String lang)
    {
        String langPref = "Language";
        SharedPreferences prefs = getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(langPref, lang);
        editor.commit();
    }
    public void loadLocale()
    {
        String langPref = "Language";
        SharedPreferences prefs = getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        String language = prefs.getString(langPref, "");
        changeLang(language);
    }

    public void saveLangupreference(int i){

        if(i==1){

            String lang = "bn";

            changeLang(lang);

            SharedPreferences savedata = getApplicationContext().getSharedPreferences("Language", Context.MODE_PRIVATE);

            SharedPreferences.Editor editdata = savedata.edit();

            editdata.putString("language", "bn");

            editdata.commit();

            Intent refresh = new Intent(this,AboutUs.class);
            startActivity(refresh);
            finish();

        }

        else  if(i==0){

            String lang = "en";

            changeLang(lang);

            SharedPreferences savedata = getApplicationContext().getSharedPreferences("Language", Context.MODE_PRIVATE);

            SharedPreferences.Editor editdata = savedata.edit();

            editdata.putString("language", "en");

            editdata.commit();

            Intent refresh = new Intent(this, AboutUs.class);
            startActivity(refresh);
            finish();

        }


    }


}
