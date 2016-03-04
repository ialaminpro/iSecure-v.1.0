package com.shakil.iCare_Health;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.warriors.iCare_Health.R;


public class Doctor_Show extends ActionBarActivity {
    String id_name;
    TextView name, qualification, designation, expertise, organization, chamber, location, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor__show);
        Intent in = getIntent();
        name = (TextView) findViewById(R.id.tv_Name);
        qualification = (TextView) findViewById(R.id.tv_Qualification);
        designation = (TextView) findViewById(R.id.tv_Designation);
        expertise = (TextView) findViewById(R.id.tv_Expertise);
        organization = (TextView) findViewById(R.id.tv_Organization);
        chamber = (TextView) findViewById(R.id.tv_Chamber);
        location = (TextView) findViewById(R.id.tv_Location);
        phone = (TextView) findViewById(R.id.tv_phone);


        String[] doctor = in.getStringArrayExtra("string0fDoctor");
        id_name = doctor[1];

        name.setText(doctor[1]);
        qualification.setText(doctor[2]);
        designation.setText(doctor[3]);
        expertise.setText(doctor[4]);
        organization.setText(doctor[5]);
        chamber.setText(doctor[6]);
        location.setText(doctor[7]);
        phone.setText(doctor[8]);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_profile__show, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_edit) {
            Intent in = new Intent(Doctor_Show.this, Doctor_Edit.class);
            in.putExtra("name",id_name);
            startActivity(in);
        }
        else if(id == R.id.action_delete){
            DatabaseHelper db = new DatabaseHelper(getBaseContext());

            db.deleteDoctor(id_name);
            Toast.makeText(Doctor_Show.this, "Deleted Successfully" , Toast.LENGTH_SHORT).show();

            startActivity(new Intent(Doctor_Show.this, DoctorList.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
