package com.shakil.iCare_Health;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.warriors.iCare_Health.R;


public class Doctor_Edit extends ActionBarActivity {
    EditText et_Name, qualification, designation, expertise, organization, chamber, location, phone;
    Button button;
    String clicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor__edit);
        et_Name = (EditText) findViewById(R.id.et_Name);
        qualification = (EditText) findViewById(R.id.et_Qualification);
        designation = (EditText) findViewById(R.id.et_Designation);
        expertise = (EditText) findViewById(R.id.et_Expertise);
        organization = (EditText) findViewById(R.id.et_Organization);
        chamber = (EditText) findViewById(R.id.et_Chamber);
        location = (EditText) findViewById(R.id.et_Location);
        phone = (EditText) findViewById(R.id.et_Phone);

        button = (Button) findViewById(R.id.btnDocUpdate);


        qualification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = onCreateDialogSingleChoice(qualification,"Qualification", new String[]{"MBBS", "MPhil", "FCPS", "FRCS", "FICS", "PGT", "DDSC", "Others"});
                dialog.show();
            }
        });


        designation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = onCreateDialogSingleChoice(designation,"Designation", new String[]{"Professor", "Consultant", "Others"});
                dialog.show();
            }
        });


        expertise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = onCreateDialogSingleChoice(expertise,"Expertise", new String[]{"General Surgeon", "Hematology", "Psychiatry", "Urology", "DEFR", "Others"});
                dialog.show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper db = new DatabaseHelper(getApplicationContext());
                Intent in = getIntent();
                String name = in.getStringExtra("name");
                Doctor doctor = db.getDoctor(name);

                doctor.setName(et_Name.getText().toString());
                doctor.setQualification(qualification.getText().toString());
                doctor.setDesignation(designation.getText().toString());
                doctor.setExpertise(expertise.getText().toString());
                doctor.setOrganization(organization.getText().toString());
                doctor.setChamber(chamber.getText().toString());
                doctor.setLocation(location.getText().toString());
                doctor.setPhone(phone.getText().toString());

                db.updateDoctor(doctor);

                startActivity(new Intent(Doctor_Edit.this, DoctorList.class));
                Toast.makeText(getApplicationContext(), "Updated Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        Intent in = getIntent();
        String name = in.getStringExtra("name");

        DatabaseHelper db = new DatabaseHelper(this);
        Doctor doctor = db.getDoctor(name);



        et_Name.setText(doctor.getName());
        qualification.setText(doctor.getQualification());
        designation.setText(doctor.getDesignation());
        expertise.setText(doctor.getExpertise());
        organization.setText(doctor.getOrganization());
        chamber.setText(doctor.getChamber());
        location.setText(doctor.getLocation());
        phone.setText(doctor.getPhone());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile_edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public AlertDialog onCreateDialogSingleChoice(final EditText editText,String title, final CharSequence[] array) {
        clicked = array[0].toString();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title).setSingleChoiceItems(array, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                clicked = array[which].toString();
            }
        })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        editText.setText(clicked);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });

        return builder.create();
    }

}

