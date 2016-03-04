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


public class ProfileEditActivity extends ActionBarActivity {

    EditText etName, etPhone, etGender, etBlood;
    Button button;
    String clicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);
        etName = (EditText) findViewById(R.id.etName);
        etPhone = (EditText) findViewById(R.id.stroke_d);
        etBlood = (EditText) findViewById(R.id.etBloodGroup);
        etGender = (EditText) findViewById(R.id.etGender);
        button = (Button) findViewById(R.id.button);


        etGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = onCreateDialogSingleChoice(etGender,"Gender", new String[]{"Male", "Female"});
                dialog.show();
            }
        });

        etBlood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = onCreateDialogSingleChoice(etBlood,"Blood Group", new String[]{"A +ve", "A -ve","B +ve","B -ve", "AB +ve", "AB -ve", "O +ve", "O -ve"});
                dialog.show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper db = new DatabaseHelper(getApplicationContext());
                Intent in = getIntent();
                String name = in.getStringExtra("name");
                Profile profile = db.getProfile(name);
                profile.setName(etName.getText().toString());
                profile.setPhone(etPhone.getText().toString());
                profile.setGender(etGender.getText().toString());
                profile.setBloodGroup(etBlood.getText().toString());
                db.updateProfile(profile);



                startActivity(new Intent(ProfileEditActivity.this, ProfileListActivity.class));
                Toast.makeText(getApplicationContext(), "Updated Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        Intent in = getIntent();
        String name = in.getStringExtra("name");

        DatabaseHelper db = new DatabaseHelper(this);
        Profile profile = db.getProfile(name);
        etName.setText(profile.getName());
        etPhone.setText(profile.getPhone());
        etGender.setText(profile.getGender());
        etBlood.setText(profile.getBloodGroup());

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

