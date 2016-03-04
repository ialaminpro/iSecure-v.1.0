package com.shakil.iCare_Health;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.warriors.iCare_Health.R;

/**
 * Created by spy on 7/1/15.
 */




    public class Health_Edit extends ActionBarActivity {

    String clicked = "";
    EditText blood, stroke, mantal,injury;
    Button btn_health_save;
    Profile_Show ps=new Profile_Show();
    String Id_name;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.health_information);
            blood = (EditText) findViewById(R.id.editText15);
            stroke = (EditText) findViewById(R.id.editText16);
            mantal = (EditText) findViewById(R.id.editText17);
            injury = (EditText) findViewById(R.id.editText18);
            btn_health_save = (Button) findViewById(R.id.btn_health_save);


            btn_health_save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DatabaseHelper db = new DatabaseHelper(getBaseContext());
                    Intent in = getIntent();
                    String name = in.getStringExtra("name");

                    Health_inforamtion hi = db.getHealth(name);
                    hi.setName(name);
                    hi.setBlood_pressure(blood.getText().toString());
                    hi.setMental_health(mantal.getText().toString());
                    hi.setStoke(stroke.getText().toString());
                    hi.setInjury(injury.getText().toString());
                    db.updateHealth(name, hi);

                    Toast.makeText(getApplicationContext(), "Updated Successfully", Toast.LENGTH_SHORT).show();

                    in = new Intent(Health_Edit.this, health_show.class);
                    in.putExtra("Global_name", name);
                    startActivity(in);

                }
            });
            Intent in = getIntent();
            String name = in.getStringExtra("name");

            DatabaseHelper db = new DatabaseHelper(this);
            Health_inforamtion hi = db.getHealth(name);
            blood.setText(hi.getBlood_pressure());
            stroke.setText(hi.getStoke());
            mantal.setText(hi.getMental_health());
            injury.setText(hi.getInjury());
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_health_edit, menu);
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



