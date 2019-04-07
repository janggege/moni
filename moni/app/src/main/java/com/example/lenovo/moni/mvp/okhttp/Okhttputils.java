package com.example.lenovo.moni.mvp.okhttp;

import android.util.Log;

import java.util.Map;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/*Time:2019/4/4
 *Author:刘江
 *Description:
 */public class Okhttputils {
    public static Okhttputils okhttputils = null;
    public static OkHttpClient okHttpClient = null;

    public Okhttputils() {
    }

    public static Okhttputils getinstance() {
        if (okhttputils == null) {
            synchronized (Okhttputils.class) {
                if (okhttputils == null) {
                    okhttputils = new Okhttputils();
                }
            }
        }
        return okhttputils;
    }

    public static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.i("aaa", "log: " + message);
                }
            });
            okHttpClient=new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        }
        return okHttpClient;
    }

    public void doGet(String url, Callback callback) {
        Request build = new Request.Builder().url(url).build();
        getOkHttpClient().newCall(build).enqueue(callback);
    }

    public void doPost(String url, Map<String, String> lits, Callback callback) {
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : lits.keySet()) {
            builder.add(key, lits.get(key));
        }
        FormBody build = builder.build();
        Request build1 = new Request.Builder().url(url).post(build).build();
        getOkHttpClient().newCall(build1).enqueue(callback);
    }
}
