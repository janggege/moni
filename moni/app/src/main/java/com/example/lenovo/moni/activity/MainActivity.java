package com.example.lenovo.moni.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.lenovo.moni.R;
import com.example.lenovo.moni.fragment.My;
import com.example.lenovo.moni.fragment.Shouye;

public class MainActivity extends AppCompatActivity {

    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        final FragmentTransaction beginTransaction = manager.beginTransaction();
        RadioGroup group = findViewById(R.id.group);
        final My my = new My();
        final Shouye shouye = new Shouye();
        beginTransaction.add(R.id.fram, my);
        beginTransaction.add(R.id.fram, shouye);
        beginTransaction.show(shouye).hide(my);
        beginTransaction.commit();
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                FragmentTransaction beginTransaction1 = manager.beginTransaction();
                switch (i) {
                    case R.id.bt1:
                        beginTransaction1.show(shouye).hide(my);
                        break;
                    case R.id.bt2:
                        beginTransaction1.hide(shouye).show(my);
                        break;
                }
                beginTransaction1.commit();
            }
        });
    }
}
