package com.example.sunshineairlines;

import android.app.DatePickerDialog;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class FlightScheduleManagement extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_schedule_management);

        String  url="http://192.168.67.1:8080/SunshineAirlines/getCityNames";
        Http.post(url,handler,29);
        ImageButton imDa=(ImageButton)findViewById(R.id.imDa);
        ImageButton imTo=(ImageButton)findViewById(R.id.imTo);
        imDa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog =new DatePickerDialog(FlightScheduleManagement.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        EditText edDa=(EditText)findViewById(R.id.edDa);
                        String date =String.format("%04d-%02d-%02d",year,month+1,day);
                        edDa.setText(date);
                    }
                },2020,12,32);
                datePickerDialog.show();
            }
        });
        imTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog =new DatePickerDialog(FlightScheduleManagement.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        EditText edTo=(EditText)findViewById(R.id.edTo);
                        String date =String.format("%04d-%02d-%02d",year,month+1,day);
                        edTo.setText(date);
                    }
                },2020,12,32);
                datePickerDialog.show();
            }
        });
    }
    public Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            ArrayList<String> list=new ArrayList<>();
            if(msg.what==29){
                try {
                    JSONObject json=new JSONObject(msg.obj.toString());
                    if(json.get("flag").equals("success")){
                        JSONArray arr=(JSONArray)json.get("data");
                        for (int i = 0; i < arr.length(); i++) {
                            JSONObject obj=(JSONObject)arr.get(i);
                            String cityName=obj.get("CityName").toString();
                            list.add(cityName);
                        }
                    }

                    Spinner fmCity=(Spinner) findViewById(R.id.fmCity);
                    Spinner toCity=(Spinner) findViewById(R.id.toCity);
                    ArrayAdapter adapter=new ArrayAdapter(FlightScheduleManagement.this, android.R.layout.simple_spinner_item,list);
                    fmCity.setAdapter(adapter);
                    toCity.setAdapter(adapter);

                }catch (Exception ex){

                }
            }
        }
    };
}