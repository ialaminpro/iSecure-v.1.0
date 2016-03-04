package com.shakil.iCare_Health;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.warriors.iCare_Health.R;

import java.util.Calendar;


public class Vaccination_Edit extends ActionBarActivity {

    private int year;
    private int month;
    private int day;

    static final int DATE_DIALOG_ID = 999;
    Vaccine vaccine;

    String selectedDate = "";
    String status = "";
    int selected = 0;
    String profileName,vaccineName;



    EditText vName, vInjectionDate,vDescription1, vDescription2, vNextDate;
    CheckBox vInjected;
    Button vClose,vSave;

    String clicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_vaccination);
        vName = (EditText) findViewById(R.id.etVName);
        vInjectionDate = (EditText) findViewById(R.id.etVInjectionDate);
        vDescription1 = (EditText) findViewById(R.id.etVDescription1);
        vDescription2 = (EditText) findViewById(R.id.etVDescription2);
        vInjected = (CheckBox) findViewById(R.id.cbInjected);
        vNextDate = (EditText) findViewById(R.id.etVNextDate);

        vClose = (Button) findViewById(R.id.btnVClose);
        vSave = (Button) findViewById(R.id.btnVSave);
        vClose.setText("Discard");
        setCurrentDateOnView();



        vInjectionDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selected=1;
                showDialog(999);
            }
        });


        vNextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = 2;
                showDialog(999);

            }
        });


        vClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Vaccination_Edit.this,activity_vaccination.class));
            }
        });



        vSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                DatabaseHelper db = new DatabaseHelper(getBaseContext());
                Vaccine vaccine = new Vaccine(profileName,vName.getText().toString(), vInjectionDate.getText().toString(), vDescription1.getText().toString(), statusCheck(), vDescription2.getText().toString(),vNextDate.getText().toString());
                db.updateVaccine(profileName,vaccineName,vaccine);
                Toast.makeText(Vaccination_Edit.this, "Updated Successfully" , Toast.LENGTH_SHORT).show();

                status = "";

                Intent in = new Intent(Vaccination_Edit.this, activity_vaccination.class);
                startActivity(in);

            }
        });


        Intent in = getIntent();
        profileName = in.getStringExtra("profileName");
        vaccineName = in.getStringExtra("vaccineName");

        DatabaseHelper db = new DatabaseHelper(this);
        vaccine = db.getVaccine(profileName,vaccineName);

        vName.setText(vaccine.getVaccineName());
        vInjectionDate.setText(vaccine.getDate());
        vDescription1.setText(vaccine.getDescription1());

        if(vaccine.getStatus().equals("Yes")){
            vInjected.setChecked(true);
        }
        vDescription2.setText(vaccine.getDescription2());



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




    @Override
    protected Dialog onCreateDialog(int id) {
        ;
        switch (id) {
            case DATE_DIALOG_ID:
                // set date picker as current date

                return new DatePickerDialog(this, datePickerListener,
                        year, month,day);
        }
        return null;
    }

    public void setCurrentDateOnView() {
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        // set current date into textview
        vInjectionDate.setText(new StringBuilder()
                // Month is 0 based, just add 1
                .append(month + 1).append("-").append(day).append("-")
                .append(year).append(" "));

    }



    private DatePickerDialog.OnDateSetListener datePickerListener
            = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;
            StringBuilder select;


            if(day<10 && month<10){

                select = new StringBuilder()
                        // Month is 0 based, just add 1
                        .append('0').append(day).append("-").append('0').append(month + 1).append("-")
                        .append(year).append(" ");
            }


            else if(day<10){
                select = new StringBuilder()
                        // Month is 0 based, just add 1
                        .append('0').append(day).append("-").append(month + 1).append("-")
                        .append(year).append(" ");
            }

            else if(month < 10){
                select = new StringBuilder()
                        // Month is 0 based, just add 1
                        .append(day).append("-").append('0').append(month + 1).append("-")
                        .append(year).append(" ");
            }

            else{
                select = new StringBuilder()
                        // Month is 0 based, just add 1
                        .append(day).append("-").append(month + 1).append("-")
                        .append(year).append(" ");
            }



            selectedDate = select.toString();

            if(selected == 1){
                vInjectionDate.setText(selectedDate);
                selected = 0;
            }

            else if(selected == 2){
                vNextDate.setText(selectedDate);
                selected = 0;
            }
            else {

            }
        }
    };

    public String statusCheck(){
        if(vInjected.isChecked()){
            status = "Yes";
        }
        else{
            status = "No";
        }

        return status;
    }


}
