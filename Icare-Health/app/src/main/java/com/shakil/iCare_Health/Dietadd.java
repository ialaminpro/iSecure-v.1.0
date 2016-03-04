package com.shakil.iCare_Health;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.warriors.iCare_Health.R;

/**
 * Created by spy on 7/1/15.
 */
public class Dietadd extends ActionBarActivity {
    String clicked = "";
    EditText breakfast_1,breakfast_2,breakfast_3,lunch_1,lunch_2,lunch_3,dinner_1,dinner_2,dinner_3;
    Button btn_diet_save;

    String Id_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_sunday);
        Intent in = getIntent();
        Id_name = in.getStringExtra("Global_name");

        breakfast_1 = (EditText) findViewById(R.id.editText);
        breakfast_2 = (EditText) findViewById(R.id.editText2);
        breakfast_3 = (EditText) findViewById(R.id.editText8);
        lunch_1 = (EditText) findViewById(R.id.editText9);
        lunch_2 = (EditText) findViewById(R.id.editText10);
        lunch_3 = (EditText) findViewById(R.id.editText11);
        dinner_1=(EditText) findViewById(R.id.editText12);
        dinner_2 = (EditText) findViewById(R.id.editText13);
        dinner_3 = (EditText) findViewById(R.id.editText14);
        btn_diet_save =(Button) findViewById(R.id.button12);





        btn_diet_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper db = new DatabaseHelper(getBaseContext());
                db.adddiet(new Diet(Id_name,breakfast_1.getText().toString(),breakfast_2.getText().toString(), breakfast_3.getText().toString(),lunch_1.getText().toString(),lunch_2.getText().toString(),lunch_3.getText().toString(),dinner_1.getText().toString(),dinner_2.getText().toString(),dinner_3.getText().toString()));

                Toast.makeText(Dietadd.this, "SAVED", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(Dietadd.this,Diet_show.class);
                in.putExtra("Global_name", Id_name);

                startActivity(in);

                Toast.makeText(Dietadd.this, "SAVED", Toast.LENGTH_LONG).show();

            }
        });
    }
}
