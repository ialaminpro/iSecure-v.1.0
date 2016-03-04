package com.shakil.iCare_Health;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.warriors.iCare_Health.R;


public class health_show extends ActionBarActivity {
    String id_name;
    TextView blood_pressure,stroke,mantal,injury ;
    Button btn_edit_health;

     Profile_Show ps=new Profile_Show();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health_informatin_show);
        Intent in = getIntent();
        id_name = in.getStringExtra("Global_name");

        blood_pressure= (TextView) findViewById(R.id.blood_pr);
        stroke = (TextView) findViewById(R.id.stroke_d);
        mantal = (TextView) findViewById(R.id.mant);
        injury = (TextView) findViewById(R.id.inju);

//        String[] profile = in.getStringArrayExtra("string0fprofile");
        DatabaseHelper db = new DatabaseHelper(this);
        Health_inforamtion health = db.getHealth(id_name);

        blood_pressure.setText(health.getBlood_pressure());
        mantal.setText(health.getMental_health());
        injury.setText(health.getInjury());
        stroke.setText(health.getStoke());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_health_show, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_edit_health) {


            Intent in = new Intent(health_show.this, Health_Edit.class);
            in.putExtra("name",id_name);
            startActivity(in);
        }
        else if(id == R.id.action_delete_health){
            DatabaseHelper db = new DatabaseHelper(getBaseContext());

            db.deleteHealth(id_name);
            Toast.makeText(health_show.this, "Deleted Successfully" , Toast.LENGTH_SHORT).show();

            startActivity(new Intent(health_show.this, new_health.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
