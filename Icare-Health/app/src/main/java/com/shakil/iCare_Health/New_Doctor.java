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


public class New_Doctor extends ActionBarActivity {
    String clicked = "";
    EditText name, qualification, designation, expertise, organization, chamber, location, phone;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__doctor);
        name = (EditText) findViewById(R.id.et_Name);
        qualification = (EditText) findViewById(R.id.et_Qualification);
        designation = (EditText) findViewById(R.id.et_Designation);
        expertise = (EditText) findViewById(R.id.et_Expertise);
        organization = (EditText) findViewById(R.id.et_Organization);
        chamber = (EditText) findViewById(R.id.et_Chamber);
        location = (EditText) findViewById(R.id.et_Location);
        phone = (EditText) findViewById(R.id.et_Phone);
        btnSave =(Button) findViewById(R.id.btnAddDoctor);


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

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Doctor doctor = new Doctor(name.getText().toString(),qualification.getText().toString(),designation.getText().toString(),expertise.getText().toString(),
                        organization.getText().toString(), chamber.getText().toString(),location.getText().toString(),phone.getText().toString());


                if (name.getText().toString().length() < 3 && phone.getText().toString().length() <3){
                    Toast.makeText(New_Doctor.this, "Name should be at least two characters", Toast.LENGTH_SHORT).show();
                    Toast.makeText(New_Doctor.this, "Phone number should be at least three characters", Toast.LENGTH_SHORT).show();
                }

                else if(name.getText().toString().length() < 3 )
                    Toast.makeText(New_Doctor.this, "Name should be at least three characters", Toast.LENGTH_SHORT).show();

                else if(phone.getText().toString().length() <3)
                    Toast.makeText(New_Doctor.this, "Phone number should be at least three characters", Toast.LENGTH_SHORT).show();
                else{
                    DatabaseHelper db = new DatabaseHelper(getBaseContext());
                    db.addDoctor(new Doctor(name.getText().toString(), qualification.getText().toString(), designation.getText().toString(), expertise.getText().toString(), organization.getText().toString(), chamber.getText().toString(), location.getText().toString(), phone.getText().toString()));
                    Toast.makeText(New_Doctor.this, "Doctor Created", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(New_Doctor.this, DoctorList.class);
                    startActivity(in);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new__doctor, menu);
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
