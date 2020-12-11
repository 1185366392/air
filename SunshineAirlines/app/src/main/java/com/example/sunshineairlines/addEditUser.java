package com.example.sunshineairlines;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.json.JSONObject;

public class addEditUser extends AppCompatActivity implements View.OnClickListener {

    private EditText emailbox;
    private EditText fname;
    private EditText lname;
    private EditText phone;
    private EditText address;
    private RadioButton reUser;
    private RadioButton reMale;
    private Button submitbtn;
    private Button cancelBtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_user);
        submitbtn=(Button)findViewById(R.id.submitbtn);
        cancelBtn1=(Button)findViewById(R.id.cancelBtn1);
        submitbtn.setOnClickListener(this);
        cancelBtn1.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.submitbtn){
            emailbox=(EditText)findViewById(R.id.emailbox);
            fname=(EditText)findViewById(R.id.fname);
            lname=(EditText)findViewById(R.id.lname);
            phone=(EditText)findViewById(R.id.phone);
            address=(EditText)findViewById(R.id.address);

            String emailtext=emailbox.getText().toString();
            String fnametext=fname.getText().toString();
            String lnametext=lname.getText().toString();
            String phonetext=phone.getText().toString();
            String addresstext=address.getText().toString().replace(" ","");//将空格替换为空字符串避免出现400错误

            reUser=(RadioButton)findViewById(R.id.reUser);
            reMale=(RadioButton)findViewById(R.id.reMale);

            String roleId=reUser.isChecked()?"1":"2";
            String gender=reUser.isChecked()?"M":"F";
            String photo="";//照片暂时为空
            String dateOfbirth="";//生日暂为空

            String url="http://10.0.2.2:8080/SunshineAirlines/addUser?roleId="+roleId+
                    "&email="+emailtext+"&firstName="+fnametext+"&lastName="+lnametext+"&gender="+gender+"&dateOfBirth="+dateOfbirth+"&phone="+phonetext+"&photo="+photo+"&address="+addresstext;
            Http.post(url,handler,666);
        }else{
            Intent intent=new Intent(addEditUser.this,UserManagement.class);
            startActivity(intent);
        }
    }
    public Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what==666){
                try{
                    JSONObject json=new JSONObject(msg.obj.toString());
                    if(json.get("flag").equals("success")){
                        Toast.makeText(addEditUser.this,"success",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(addEditUser.this,json.get("data").toString(),Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(addEditUser.this, "出错了哦,亲!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

}