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
import android.widget.RadioGroup;
import android.widget.Toast;

import com.warriors.iCare_Health.R;


public class New_Profile extends ActionBarActivity {
    EditText name,phone,gender,blood;
    Button submit;
    RadioGroup rgGender;
    Profile profile;
    String clicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__profile);
        name = (EditText) findViewById(R.id.etName);
        phone = (EditText) findViewById(R.id.stroke_d);
        gender = (EditText) findViewById(R.id.etGender);
        blood = (EditText) findViewById(R.id.etBloodGroup);

        submit = (Button) findViewById(R.id.button);
        profile = new Profile(name.getText().toString(), phone.getText().toString(), gender.getText().toString(), blood.getText().toString());


        gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = onCreateDialogSingleChoice(gender,"Gender", new String[]{"Male", "Female"});
                dialog.show();
            }
        });

        blood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = onCreateDialogSingleChoice(blood,"Blood Group", new String[]{"A +ve", "A -ve","B +ve","B -ve", "AB +ve", "AB -ve", "O +ve", "O -ve"});
                dialog.show();
            }
        });

//        DatabaseHelper db = new DatabaseHelper(this);
//        SQLiteDatabase db2 = db.getWritableDatabase();
//        db2.execSQL("DELETE db_profile");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().length() < 3 && phone.getText().toString().length() <3){
                    Toast.makeText(New_Profile.this, "Name should be at least two characters", Toast.LENGTH_SHORT).show();
                    Toast.makeText(New_Profile.this, "Phone number should be at least three characters", Toast.LENGTH_SHORT).show();
                }

                else if(name.getText().toString().length() < 3 )
                    Toast.makeText(New_Profile.this, "Name should be at least three characters", Toast.LENGTH_SHORT).show();

                else if(phone.getText().toString().length() <3)
                    Toast.makeText(New_Profile.this, "Phone number should be at least three characters", Toast.LENGTH_SHORT).show();
                else{
                    DatabaseHelper db = new DatabaseHelper(getBaseContext());
                    db.addProfile(new Profile(name.getText().toString(), phone.getText().toString(), gender.getText().toString(), blood.getText().toString()));
                    Toast.makeText(New_Profile.this, "Profile Created", Toast.LENGTH_SHORT).show();

                    Intent in = new Intent(New_Profile.this, ProfileListActivity.class);
                    startActivity(in);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new__profile, menu);
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
