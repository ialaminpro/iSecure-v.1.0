package com.shakil.iCare_Health;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.warriors.iCare_Health.R;

import java.util.ArrayList;
import java.util.List;


public class ProfileListActivity extends ActionBarActivity {

    ListView profilelistView;
    Button btnCreateProfile,button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_list);
        profilelistView = (ListView) findViewById(R.id.profilelistView);
        ArrayList<String> profileList = new ArrayList<String>();

        ProfileAdapter profileAdapter=new ProfileAdapter(ProfileListActivity.this, profileList);
        profilelistView.setAdapter(profileAdapter);
        button3= (Button) findViewById(R.id.button3);
        btnCreateProfile = (Button) findViewById(R.id.btnVaccinationadd);
        btnCreateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileListActivity.this, New_Profile.class));
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileListActivity.this, home.class));
            }
        });



        DatabaseHelper db = new DatabaseHelper(this);

        SQLiteDatabase db2 = db.getWritableDatabase();



        List<Profile> profiles = db.getAllProfiles();

        for(Profile profile : profiles){
            profileList.add(profile.getName());

        }

        profilelistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DatabaseHelper db = new DatabaseHelper(getApplicationContext());

                Intent in = new Intent(ProfileListActivity.this, Profile_Show.class);

                String test = profilelistView.getItemAtPosition(position).toString();


                Profile profile = db.getProfile(test);
                String[] profileString = {String.valueOf(profile.getId()), profile.getName(), profile.getPhone(), profile.getGender(), profile.getBloodGroup()};
                in.putExtra("string0fprofile", profileString);
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

        if (id == R.id.sendSms) {
            sendSMS();
            return true;
        }

        else if (id == R.id.sendMail) {
            sendEmail();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    protected void sendSMS() {
        Log.i("Send SMS", "");
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);

        smsIntent.setData(Uri.parse("smsto:"));
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address"  , new String ("01234"));
        smsIntent.putExtra("sms_body"  , "Test ");

        try {
            startActivity(smsIntent);
            finish();
            Log.i("Finished sending SMS...", "");
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(ProfileListActivity.this,
                    "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
        }
    }

    protected void sendEmail() {
        Log.i("Send email", "");
        String[] TO = {""};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            //Log.i("Finished sending email...", " ");
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(ProfileListActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }




}
