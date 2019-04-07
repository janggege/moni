package com.example.lenovo.moni.mvp.model;

import com.example.lenovo.moni.mvp.Myinterface.Reginterface;
import com.example.lenovo.moni.mvp.okhttp.Okhttputils;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/*Time:2019/4/4
 *Author:刘江
 *Description:
 */public class Regmodel implements Reginterface.Regmodel {
    @Override
    public void Requset(Map<String, String> list, final Callback callback) {
        String url = "http://172.17.8.100/small/user/v1/register";
        Okhttputils.getinstance().doPost(url, list, new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.shibsai();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.chenggong(response.body().string());

            }
        });

    }
}
