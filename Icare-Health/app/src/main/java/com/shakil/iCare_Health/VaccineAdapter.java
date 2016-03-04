package com.shakil.iCare_Health;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.warriors.iCare_Health.R;

import java.util.ArrayList;

public class VaccineAdapter extends ArrayAdapter<String> {

    private Context context;
    private ArrayList<String> myValue;

    public VaccineAdapter(Context context,ArrayList<String> myValue) {
        super(context, R.layout.vaccination_adapter, myValue);
        this.context = context;
        this.myValue=myValue;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        View s;

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View showView = inflater.inflate(R.layout.vaccination_adapter, parent, false);
        TextView textView = (TextView)showView.findViewById(R.id.tv_vaccine);

        textView.setText(myValue.get(position));

        String str = myValue.get(position);



        return showView;


    }


}
