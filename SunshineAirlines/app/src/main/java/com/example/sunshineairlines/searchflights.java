package com.example.sunshineairlines;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class searchflights extends AppCompatActivity implements View.OnClickListener {

    private Button back1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchflights);
        back1=(Button)findViewById(R.id.back1);
        back1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(this,FlightScheduleManagementResult.class);
        startActivity(intent);
    }
}