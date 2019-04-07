

package com.example.lenovo.moni.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.lenovo.moni.R;
import com.example.lenovo.moni.mvp.Myinterface.Xiangqinginterface;
import com.example.lenovo.moni.mvp.presenter.Xiangqingpresenter;
import com.google.gson.Gson;

public class Xiangqing extends AppCompatActivity implements Xiangqinginterface.Xiangqingview {
    private Xiangqingpresenter xiangqingpresenter;
    private ImageView imageView;
    private TextView textView;
    private TextView price;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangqing);
        Intent intent = getIntent();
        int pid = intent.getExtras().getInt("pid");

        Toast.makeText(this, "pid:" + pid, Toast.LENGTH_SHORT).show();
        xiangqingpresenter = new Xiangqingpresenter();
        xiangqingpresenter.attchview(this);
        xiangqingpresenter.getda(pid);
        imageView = findViewById(R.id.ximage);
        textView = findViewById(R.id.xtext1);
        price = findViewById(R.id.price);
    }

    @Override
    public void Xianagqingview(final String data) {
        Log.i("hhhhhhhhh", "Xianagqingview: "+data);
        handler.post(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                com.example.lenovo.moni.mvp.bean.Xiangqing xiangqing = gson.fromJson(data, com.example.lenovo.moni.mvp.bean.Xiangqing.class);

                com.example.lenovo.moni.mvp.bean.Xiangqing.DataBean data1 = xiangqing.getData();
                String images = data1.getImages();
                String title = data1.getTitle();
                double price1 = data1.getPrice();
                Glide.with(Xiangqing.this).load(images).into(imageView);
                textView.setText(title);
                Xiangqing.this.price.setText(price1+"");
            }
        });

    }
}
