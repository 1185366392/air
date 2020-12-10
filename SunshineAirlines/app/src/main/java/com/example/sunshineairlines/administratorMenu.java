package com.example.sunshineairlines;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class administratorMenu extends AppCompatActivity implements View.OnClickListener {

    private Button Logoutbtn;
    private Button userManage;
    private Button fsManage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administratormenu);

        Logoutbtn=(Button) findViewById(R.id.Logoutbtn);
        userManage=(Button) findViewById(R.id.userManage);
        fsManage=(Button) findViewById(R.id.fsManage);
        Logoutbtn.setOnClickListener(this);
        userManage.setOnClickListener(this);
        fsManage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.Logoutbtn:{
                Intent intent=new Intent(administratorMenu.this,loginScreen.class);
                startActivity(intent);
            }break;
            case R.id.userManage:{
                Intent intent=new Intent(administratorMenu.this,UserManagement.class);
                startActivity(intent);
            }break;
            case R.id.fsManage:{
                Intent intent=new Intent(administratorMenu.this,FlightScheduleManagement.class);
                startActivity(intent);
            }break;
        }
    }
}