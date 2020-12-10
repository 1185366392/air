package com.example.sunshineairlines;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

public class loginScreen extends AppCompatActivity implements View.OnClickListener {

    private Button login;
    private EditText email;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginscreen);
        login =(Button) findViewById(R.id.login);
        email =(EditText) findViewById(R.id.email);
        password =(EditText) findViewById(R.id.password);

        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String url="http://192.168.11.1:8080/SunshineAirlines/login?email="+email.getText().toString()+"&password="+password.getText().toString();

        Http.post(url,handler,123);
    }
    //子线程
    public Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            try {
                if(msg.what==123){
                    JSONObject json = new JSONObject(msg.obj.toString());
                    String flag =json.get("flag").toString();
                    if(flag.equals("fail")){
                        String data=json.get("data").toString();
                        Toast.makeText(loginScreen.this,data,Toast.LENGTH_SHORT).show();
                    }else{
                        String roleId=json.getJSONObject("data").get("RoleId").toString();
                        if(roleId.equals("1")){
                            Intent intent=new Intent(loginScreen.this,officeUserMenu.class);
                            startActivity(intent);
                        }else{
                            Intent intent=new Intent(loginScreen.this,administratorMenu.class);
                            startActivity(intent);
                        }
                    }
                }
            }catch (Exception e) {
                Toast.makeText(loginScreen.this, "报错了", Toast.LENGTH_SHORT).show();
            }
        }
    };
}