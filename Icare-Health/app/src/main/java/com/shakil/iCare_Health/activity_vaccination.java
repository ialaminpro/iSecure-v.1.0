package com.shakil.iCare_Health;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.warriors.iCare_Health.R;

import java.util.ArrayList;
import java.util.List;


public class activity_vaccination extends ActionBarActivity {
    ListView vaccineListView;
    Button btnCreateVaccine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        DatabaseHelper db = new DatabaseHelper(this);

//       db.create();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccination);
        vaccineListView = (ListView) findViewById(R.id.vaccineListView);
        ArrayList<String> vaccineList = new ArrayList<String>();

        VaccineAdapter vaccineAdapter=new VaccineAdapter(activity_vaccination.this, vaccineList);
        vaccineListView.setAdapter(vaccineAdapter);

        btnCreateVaccine = (Button) findViewById(R.id.btnVaccineAdd);
        btnCreateVaccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_vaccination.this, newVaccination.class));
            }
        });





       // DatabaseHelper db = new DatabaseHelper(this);

        //SQLiteDatabase db2 = db.getWritableDatabase();

       // db2.execSQL("CREATE TABLE doctors (id INTEGER PRIMARY KEY, name TEXT,qualification TEXT,designation TEXT, expertise TEXT,organization TEXT, chamber TEXT, location TEXT, phone TEXT), email TEXT");




        List<Vaccine> vaccines = db.getAllVaccine("Shakil");

        for(Vaccine vaccine : vaccines){
            vaccineList.add(vaccine.getVaccineName());

        }

        vaccineListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DatabaseHelper db = new DatabaseHelper(getApplicationContext());

                Intent in = new Intent(activity_vaccination.this,Vaccination_show.class);

                String test = vaccineListView.getItemAtPosition(position).toString();


                Vaccine vaccine = db.getVaccine("Shakil", test);
                String[] vaccineString = {String.valueOf(vaccine.getId()), vaccine.getProfileName(), vaccine.getVaccineName(), vaccine.getDate(), vaccine.getDescription1(), vaccine.getStatus(), vaccine.getDescription2(), vaccine.getNextDate()};
                in.putExtra("string0fVaccine", vaccineString);
                startActivity(in);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
//
//        if (id == R.id.de) {
//            sendSMS();
//            return true;
//        }
//
//        else if (id == R.id.sendMail) {
//            sendEmail();
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }



}
