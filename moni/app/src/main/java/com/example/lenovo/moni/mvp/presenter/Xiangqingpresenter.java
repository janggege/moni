package com.example.lenovo.moni.mvp.presenter;

import com.example.lenovo.moni.mvp.Myinterface.Xiangqinginterface;
import com.example.lenovo.moni.mvp.model.Xiangqingmodel;

import java.lang.ref.SoftReference;

/*Time:2019/4/4
 *Author:刘江
 *Description:
 */public class Xiangqingpresenter implements Xiangqinginterface.Xiangqingpresentr {

    private Xiangqingmodel xiangqingmodel;
    private SoftReference<Xiangqingmodel> xiangqingmodelSoftReference;
    Xiangqinginterface.Xiangqingview Xiangqingview;

    @Override
    public void attchview(Xiangqinginterface.Xiangqingview Xiangqingview) {
        xiangqingmodel = new Xiangqingmodel();
        xiangqingmodelSoftReference = new SoftReference<>(xiangqingmodel);
        this.Xiangqingview=Xiangqingview;

    }

    @Override
    public void detachview() {
        xiangqingmodelSoftReference.clear();
    }

    @Override
    public void getda(int pid) {
        xiangqingmodel.Requset(pid, new Xiangqinginterface.Xiangqingmodel.Callback() {
            @Override
            public void chenggong(String data) {
                Xiangqingview.Xianagqingview(data);
            }

            @Override
            public void shibsai() {

            }
        });

    }
}
