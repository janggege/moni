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
import com.example.lenovo.moni.mvp.Myinterface.Reginterface;
import com.example.lenovo.moni.mvp.bean.Regdata;
import com.example.lenovo.moni.mvp.presenter.Regpresenter;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Regactivity extends AppCompatActivity implements Reginterface.Regview {
    private Button reg;
    private TextView lj;
    private EditText pwd1;
    private EditText name;
    private Regpresenter regpresenter;
    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regactivity);
        Initview();
        Myonclick();
    }


    private void Initview() {
        reg = findViewById(R.id.reg);
        lj = findViewById(R.id.zlj);
        pwd1 = findViewById(R.id.zpwd);
        name = findViewById(R.id.zname);
    }

    private void Myonclick() {
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pwd = pwd1.getText().toString();
                String phone = name.getText().toString();
                Map<String, String> map = new HashMap<>();
                map.put("phone", phone);
                map.put("pwd", pwd);
                regpresenter = new Regpresenter();
                regpresenter.attchview(Regactivity.this);
                regpresenter.getda(map);

            }
        });
    }


    @Override
    public void Regvire(final String data) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                Regdata regdata = gson.fromJson(data, Regdata.class);
                String status = regdata.getStatus();
                if (status.equals("0000")) {
                    Toast.makeText(Regactivity.this, regdata.getMessage(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Regactivity.this,Loginactivity.class));
                }
                else if(status.equals("1001")){
                    Toast.makeText(Regactivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
