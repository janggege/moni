package com.example.lenovo.moni.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.moni.R;
import com.example.lenovo.moni.mvp.Myinterface.Logininterface;
import com.example.lenovo.moni.mvp.bean.Logindata;
import com.example.lenovo.moni.mvp.presenter.Loginpresenter;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Loginactivity extends AppCompatActivity implements Logininterface.Loginview {

    private Button login;
    private TextView lj;
    private EditText pwd1;
    private EditText name;
    private Loginpresenter loginpresenter;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        Initview();
        Myonclick();
    }


    private void Initview() {
        login = findViewById(R.id.login);
        lj = findViewById(R.id.lj);
        pwd1 = findViewById(R.id.pwd);
        name = findViewById(R.id.name);
    }

    private void Myonclick() {
        lj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pwd = pwd1.getText().toString();
                String phone = name.getText().toString();
                Intent intent = new Intent(Loginactivity.this, Regactivity.class);
                intent.putExtra("pwd", pwd);
                intent.putExtra("phone", phone);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pwd = pwd1.getText().toString();
                String phone = name.getText().toString();
                Map<String, String> map = new HashMap<>();
                map.put("phone", phone);
                map.put("pwd", pwd);
                loginpresenter = new Loginpresenter();
                loginpresenter.attchview(Loginactivity.this);
                loginpresenter.getda(map);
            }
        });

    }

    @Override
    public void Loginview(final String data) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                Logindata logindata = gson.fromJson(data, Logindata.class);
                String status = logindata.getStatus();
                if (status.equals("0000")) {
                    Toast.makeText(Loginactivity.this, logindata.getMessage(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Loginactivity.this, MainActivity.class));
                    finish();

                } else if (status.equals("1001")) {
                    Toast.makeText(Loginactivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
