package com.example.lenovo.moni.mvp.presenter;

import com.example.lenovo.moni.mvp.Myinterface.Logininterface;
import com.example.lenovo.moni.mvp.model.Loginmodel;

import java.lang.ref.SoftReference;
import java.util.Map;

/*Time:2019/4/4
 *Author:刘江
 *Description:
 */public class Loginpresenter implements Logininterface.Loginpresenter {

    private Loginmodel loginmodel;
    private SoftReference<Loginmodel> loginmodelSoftReference;
    Logininterface.Loginview loginview;

    @Override
    public void attchview(Logininterface.Loginview loginview) {
        loginmodel = new Loginmodel();
        loginmodelSoftReference = new SoftReference<>(loginmodel);
        this.loginview = loginview;
    }

    @Override
    public void detachview() {

        loginmodelSoftReference.clear();
    }

    @Override
    public void getda(Map<String, String> list) {

        loginmodel.Requset(list, new Logininterface.Loginmodel.Callback() {
            @Override
            public void chenggong(String data) {
                loginview.Loginview(data);
            }

            @Override
            public void shibsai() {

            }
        });
    }
}
