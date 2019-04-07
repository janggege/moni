package com.example.lenovo.moni.mvp.presenter;

import com.example.lenovo.moni.mvp.Myinterface.Showinterface;
import com.example.lenovo.moni.mvp.model.Showmodel;

import java.lang.ref.SoftReference;

/*Time:2019/4/4
 *Author:刘江
 *Description:
 */public class Showpresentre implements Showinterface.Showpresenter {

    private Showmodel showmodel;
    private SoftReference<Showmodel> showmodelSoftReference;
    Showinterface.Showview Showview;

    @Override
    public void attchview(Showinterface.Showview Showview) {
        showmodel = new Showmodel();
        showmodelSoftReference = new SoftReference<>(showmodel);
        this.Showview = Showview;
    }

    @Override
    public void detachview() {
        showmodelSoftReference.clear();
    }

    @Override
    public void getda() {
        showmodel.Requset(new Showinterface.Showmodel.Callback() {
            @Override
            public void chenggong(String data) {
                Showview.Showview(data);
            }

            @Override
            public void shibsai() {

            }
        });

    }
}
