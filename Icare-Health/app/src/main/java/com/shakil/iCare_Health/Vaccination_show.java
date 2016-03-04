package com.shakil.iCare_Health;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.warriors.iCare_Health.R;

import java.util.Calendar;


public class Vaccination_show extends ActionBarActivity {
    EditText vName, vInjectionDate,vDescription1, vDescription2, vNextDate;
    TextView vInjected;
    Button vClose,vSave;

    String clicked, Id_Name,Vaccine_Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccination_show);
        vName = (EditText) findViewById(R.id.etVName);
        vInjectionDate = (EditText) findViewById(R.id.etVInjectionDate);
        vDescription1 = (EditText) findViewById(R.id.etVDescription1);
        vDescription2 = (EditText) findViewById(R.id.etVDescription2);
        vInjected = (TextView) findViewById(R.id.cbInjected);
        vNextDate = (EditText) findViewById(R.id.etVNextDate);


        vClose = (Button) findViewById(R.id.btnVClose);
       // vSave = (Button) findViewById(R.id.btnVSave);
        vClose.setText("Discard");

        Intent in = getIntent();
        String[] vaccine = in.getStringArrayExtra("string0fVaccine");
        Id_Name = vaccine[1];
        Vaccine_Name = vaccine[2];


        vName.setText(vaccine[2]);
        vInjectionDate.setText(vaccine[3]);
        vDescription1.setText(vaccine[4]);
        vInjected.setText(vaccine[5]);
        vDescription2.setText(vaccine[6]);
        vNextDate.setText(vaccine[7]);


        vName.setFocusable(false);
        vInjectionDate.setFocusable(false);
        vDescription1.setFocusable(false);
        vDescription2.setFocusable(false);
        vNextDate.setFocusable(false);

        vClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Vaccination_show.this,activity_vaccination.class));

            }
        });



//        vSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//            }
//        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_vaccination_show, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_edit) {
            Intent in = new Intent(Vaccination_show.this, Vaccination_Edit.class);
            in.putExtra("profileName",Id_Name);
            in.putExtra("vaccineName",Vaccine_Name);
            startActivity(in);
        }
        else if(id == R.id.action_delete){
            DatabaseHelper db = new DatabaseHelper(getBaseContext());

            db.deleteVaccine(Id_Name, Vaccine_Name);
            Toast.makeText(Vaccination_show.this, "Deleted Successfully" , Toast.LENGTH_SHORT).show();

            startActivity(new Intent(Vaccination_show.this, activity_vaccination.class));
        }

        return super.onOptionsItemSelected(item);
    }

}



