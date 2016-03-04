package com.shakil.iCare_Health;



import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.warriors.iCare_Health.R;

/**
 * Created by spy on 6/28/15.
 */
public class home extends ActionBarActivity{

    ImageButton btnHome,btnProfile,btnProfileList,btnHealth,btnVaccination,btnDoctor,btngrowth,btndiet,btnHelp;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);



        btnHome = (ImageButton)findViewById(R.id.btnHome);
        btnProfile =(ImageButton)findViewById(R.id.btnProfile);
        btnProfileList= (ImageButton)findViewById(R.id.btnProfileList);
        btnHealth=(ImageButton)findViewById(R.id.btnHealth);
        btnVaccination=(ImageButton)findViewById(R.id.btnVaccination);
        btnDoctor=(ImageButton)findViewById(R.id.btnDoctor);
        btngrowth=(ImageButton)findViewById(R.id.btngrowth);
        btndiet=(ImageButton)findViewById(R.id.btndiet);
        btnHelp=(ImageButton)findViewById(R.id.btnHelp);


        DatabaseHelper db2 = new DatabaseHelper(home.this);


        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(home.this, home.class));
            }
        });
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(home.this, Profile_Show.class));
            }
        });

        btnProfileList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(home.this, ProfileListActivity.class));
            }
        });
        btnHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(home.this, new_health.class));
            }
        });
        btnVaccination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(home.this, activity_vaccination.class));
            }
        });
        btnDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(home.this, DoctorList.class));
            }
        });

        btngrowth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(home.this, ProfileListActivity.class));
            }
        });

        btndiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(home.this, Dietadd.class));
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(home.this, ProfileListActivity.class));
            }
        });
    }



}
