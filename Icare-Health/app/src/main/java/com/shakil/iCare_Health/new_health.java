package com.shakil.iCare_Health;

import android.app.AlertDialog;
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


public class new_health extends ActionBarActivity {
    String clicked = "";
    EditText blood, stroke, mantal,injury;
    Button btn_health_save;
    Profile_Show ps=new Profile_Show();
    String Id_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health_information);
        Intent in = getIntent();
        Id_name = in.getStringExtra("Global_name");

        blood = (EditText) findViewById(R.id.editText15);
        stroke = (EditText) findViewById(R.id.editText16);
        mantal = (EditText) findViewById(R.id.editText17);
        injury = (EditText) findViewById(R.id.editText18);
        btn_health_save =(Button) findViewById(R.id.btn_health_save);





        btn_health_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    DatabaseHelper db = new DatabaseHelper(getBaseContext());
                    db.addhealth_information(new Health_inforamtion(Id_name,blood.getText().toString(),stroke.getText().toString(),mantal.getText().toString(),injury.getText().toString()));

                    Toast.makeText(new_health.this, "SAVED", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(new_health.this,health_show.class);
                   in.putExtra("Global_name", Id_name);

                startActivity(in);

            Toast.makeText(new_health.this, "SAVED", Toast.LENGTH_LONG).show();

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
