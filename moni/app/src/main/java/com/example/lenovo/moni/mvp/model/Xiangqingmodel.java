package com.example.lenovo.moni.mvp.model;

import com.example.lenovo.moni.mvp.Myinterface.Xiangqinginterface;
import com.example.lenovo.moni.mvp.okhttp.Okhttputils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/*Time:2019/4/4
 *Author:刘江
 *Description:
 */public class Xiangqingmodel implements Xiangqinginterface.Xiangqingmodel {
    @Override
    public void Requset(int pid, final Callback callback) {
        String url = "http://172.17.8.100/ks/product/getProductDetail?pid=" + pid + "";
        Okhttputils.getinstance().doGet(url, new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.chenggong(response.body().string());

            }
        });
    }
}
