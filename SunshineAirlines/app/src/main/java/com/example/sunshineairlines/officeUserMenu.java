package com.example.sunshineairlines;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class officeUserMenu extends AppCompatActivity implements View.OnClickListener {

    private Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_officeusermenu);

        search =(Button)findViewById(R.id.search);
        search.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(this, searchFlightsResult.class);
        startActivity(intent);
    }
}