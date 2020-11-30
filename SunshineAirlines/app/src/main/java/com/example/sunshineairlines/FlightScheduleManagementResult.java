package com.example.sunshineairlines;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class FlightScheduleManagementResult extends AppCompatActivity implements View.OnClickListener {

    private Button btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_schedule_management_result);
        btnCancel=(Button)findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(this,UserManagementResult.class);
        startActivity(intent);
    }
}