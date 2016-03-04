package com.shakil.iCare_Health;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.warriors.iCare_Health.R;

/**
 * Created by spy on 7/1/15.
 */

    public class Diet_show extends ActionBarActivity {
        String id_name;
        TextView breakfast_1,breakfast_2,breakfast_3,lunch_1,lunch_2,lunch_3,dinner_1,dinner_2,dinner_3;
        Button btn_edit_diet;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_diet_sunday_view);
            Intent in = getIntent();
            id_name = in.getStringExtra("Global_name");

            breakfast_1= (TextView) findViewById(R.id.textView39);
            breakfast_2 = (TextView) findViewById(R.id.textView40);
            breakfast_3 = (TextView) findViewById(R.id.textView41);
            lunch_1 = (TextView) findViewById(R.id.textView43);
            lunch_2 = (TextView) findViewById(R.id.textView44);
            lunch_3 = (TextView) findViewById(R.id.textView44);
            dinner_1 = (TextView) findViewById(R.id.textView47);
            dinner_2 = (TextView) findViewById(R.id.textView48);
            dinner_3 = (TextView) findViewById(R.id.textView49);

//        String[] profile = in.getStringArrayExtra("string0fprofile");
            DatabaseHelper db = new DatabaseHelper(this);
            Diet diet = db.getdiet(id_name);

            breakfast_1.setText(diet.getBreakfast_1());
            breakfast_2.setText(diet.getBreakfast_2());
            breakfast_3.setText(diet.getBreakfast_3());
            lunch_1.setText(diet.getLunch_1());
            lunch_2.setText(diet.getLunch_2());
            lunch_3.setText(diet.getLunch_3());
            dinner_1.setText(diet.getDinner_1());
            dinner_2.setText(diet.getDinner_2());
            dinner_3.setText(diet.getDinner_3());
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            getMenuInflater().inflate(R.menu.menu_diet_show, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            int id = item.getItemId();


            if (id == R.id.action_edit_diet) {


                Intent in = new Intent(Diet_show.this, Dietadd.class);
                in.putExtra("name",id_name);
                startActivity(in);
            }
            else if(id == R.id.action_delete_diet){
                DatabaseHelper db = new DatabaseHelper(getBaseContext());

                db.deleteDiet(id_name);
                Toast.makeText(Diet_show.this, "Deleted Successfully", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(Diet_show.this, new_health.class));
            }

            return super.onOptionsItemSelected(item);
        }
}
