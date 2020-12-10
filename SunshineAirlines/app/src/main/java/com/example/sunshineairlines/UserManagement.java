package com.example.sunshineairlines;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class UserManagement extends AppCompatActivity implements View.OnClickListener {

    private Button addBtn;
    private Button umBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_management);
        addBtn=(Button)findViewById(R.id.addBtn);
        umBack=(Button)findViewById(R.id.umBack);
        addBtn.setOnClickListener(this);
        umBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
//        if(view.getId()==R.id.addBtn){
//            Intent intent=new Intent(UserManagement.this,addEditUser.class);
//            startActivity(intent);
//        }else if(view.getId()==R.id.umBack){
//            Intent intent=new Intent(UserManagement.this,administratorMenu.class);
//            startActivity(intent);
//        }else{
//
//        }
        switch (view.getId()){
            case R.id.addBtn:{
                Intent intent=new Intent(UserManagement.this,addEditUser.class);
                startActivity(intent);
            }break;
            case R.id.umBack:{
                Intent intent=new Intent(UserManagement.this,administratorMenu.class);
                startActivity(intent);
            }break;
        }
    }
}