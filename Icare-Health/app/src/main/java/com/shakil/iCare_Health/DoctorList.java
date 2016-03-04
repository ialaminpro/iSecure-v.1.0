package com.shakil.iCare_Health;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.warriors.iCare_Health.R;

import java.util.ArrayList;
import java.util.List;


public class DoctorList extends ActionBarActivity {

    ListView doctorlistView;
    Button btnCreateDoctor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);
        doctorlistView = (ListView) findViewById(R.id.doctorlistView);
        ArrayList<String> doctorList = new ArrayList<String>();

        DoctorAdapter doctorAdapter=new DoctorAdapter(DoctorList.this, doctorList);
        doctorlistView.setAdapter(doctorAdapter);

        btnCreateDoctor = (Button) findViewById(R.id.btnCreateDoctor);
        btnCreateDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorList.this, New_Doctor.class));
            }
        });





        DatabaseHelper db = new DatabaseHelper(this);

        SQLiteDatabase db2 = db.getWritableDatabase();



        List<Doctor> doctors = db.getAllDoctors();

        for(Doctor doctor : doctors){
            doctorList.add(doctor.getName());

        }

        doctorlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DatabaseHelper db = new DatabaseHelper(getApplicationContext());

                Intent in = new Intent(DoctorList.this, Doctor_Show.class);

                String test = doctorlistView.getItemAtPosition(position).toString();

                Doctor doctor = db.getDoctor(test);

                String[] doctorString = {String.valueOf(doctor.getId()), doctor.getName(), doctor.getQualification(),
                        doctor.getDesignation(), doctor.getExpertise(), doctor.getOrganization(), doctor.getChamber(),
                        doctor.getLocation(), doctor.getPhone()};

                in.putExtra("string0fDoctor", doctorString);
               // Toast.makeText(DoctorList.this, doctorString[2], Toast.LENGTH_SHORT).show();
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

//        if (id == R.id.sendSms) {
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

//
//    protected void sendSMS() {
//        Log.i("Send SMS", "");
//        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
//
//        smsIntent.setData(Uri.parse("smsto:"));
//        smsIntent.setType("vnd.android-dir/mms-sms");
//        smsIntent.putExtra("address"  , new String ("01234"));
//        smsIntent.putExtra("sms_body", "Test ");
//
//        try {
//            startActivity(smsIntent);
//            finish();
//            Log.i("Finished sending SMS...", "");
//        }
//        catch (android.content.ActivityNotFoundException ex) {
//            Toast.makeText(ProfileListActivity.this,
//                    "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
//        }
//    }

//    protected void sendEmail() {
//        Log.i("Send email", "");
//        String[] TO = {""};
//        String[] CC = {""};
//        Intent emailIntent = new Intent(Intent.ACTION_SEND);
//
//        emailIntent.setData(Uri.parse("mailto:"));
//        emailIntent.setType("text/plain");
//        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
//        emailIntent.putExtra(Intent.EXTRA_CC, CC);
//        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
//        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
//
//        try {
//            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
//            finish();
//            //Log.i("Finished sending email...", " ");
//        }
//        catch (android.content.ActivityNotFoundException ex) {
//            Toast.makeText(ProfileListActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
//        }
//    }




}
