package com.example.sunshineairlines;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class officeUserMenu extends AppCompatActivity implements View.OnClickListener {

    private Button search;
    private Button logoutbtn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_officeusermenu);

        search =(Button)findViewById(R.id.search);
        logoutbtn2 =(Button)findViewById(R.id.logoutbtn2);
        search.setOnClickListener(this);
        logoutbtn2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.search){
            Intent intent=new Intent(this, searchFlightsResult.class);
            startActivity(intent);
        }else{
            Intent intent=new Intent(this, loginScreen.class);
            startActivity(intent);
        }
    }
}