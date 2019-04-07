package com.example.lenovo.moni.mvp.presenter;

import com.example.lenovo.moni.mvp.Myinterface.Reginterface;
import com.example.lenovo.moni.mvp.model.Regmodel;

import java.lang.ref.SoftReference;
import java.util.Map;

/*Time:2019/4/4
 *Author:刘江
 *Description:
 */public class Regpresenter implements Reginterface.Regpresentr {

    private Regmodel regmodel;
    private SoftReference<Regmodel> regmodelSoftReference;
    Reginterface.Regview regview;

    @Override
    public void attchview(Reginterface.Regview regview) {
        regmodel = new Regmodel();
        regmodelSoftReference = new SoftReference<>(regmodel);
        this.regview=regview;
    }

    @Override
    public void detachview() {
        regmodelSoftReference.clear();
    }

    @Override
    public void getda(Map<String, String> list) {
        regmodel.Requset(list, new Reginterface.Regmodel.Callback() {
            @Override
            public void chenggong(String data) {
                regview.Regvire(data);
            }

            @Override
            public void shibsai() {

            }
        });
    }
}
