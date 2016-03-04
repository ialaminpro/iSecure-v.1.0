package com.shakil.iCare_Health;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.warriors.iCare_Health.R;



public class Profile_Show extends ActionBarActivity {
    String id_name;
    TextView name, phone, gender, blood;
    Button btn_health_test,button16,button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile__show);
        Intent in = getIntent();
        name = (TextView) findViewById(R.id.tvName);
        phone = (TextView) findViewById(R.id.stroke_d);
        gender = (TextView) findViewById(R.id.mant);
        blood = (TextView) findViewById(R.id.tvBlood);
        button16=(Button)findViewById(R.id.button16);
        button7=(Button)findViewById(R.id.button7);
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Profile_Show.this, new_health.class);
                in.putExtra("Global_name",id_name);


                startActivity(in);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Profile_Show.this, home.class);
                in.putExtra("Global_name",id_name);


                startActivity(in);
            }
        });
        btn_health_test = (Button)findViewById(R.id.btn_health_test);
        btn_health_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Profile_Show.this, health_show.class);
                in.putExtra("Global_name",id_name);


                startActivity(in);
            }
        });

        String[] profile = in.getStringArrayExtra("string0fprofile");
        id_name = profile[1];
        name.setText(profile[1]);

        phone.setText(profile[2]);
        gender.setText(profile[3]);
        blood.setText(profile[4]);


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
            Intent in = new Intent(Profile_Show.this, ProfileEditActivity.class);
            in.putExtra("name",id_name);
            startActivity(in);
        }
        else if(id == R.id.action_delete){
            DatabaseHelper db = new DatabaseHelper(getBaseContext());

            db.deleteProfile(id_name);
            Toast.makeText(Profile_Show.this, "Deleted Successfully" , Toast.LENGTH_SHORT).show();

            startActivity(new Intent(Profile_Show.this, ProfileListActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
