package com.example.lenovo.moni.mvp.Myinterface;

import java.util.Map;

/*Time:2019/4/4
 *Author:刘江
 *Description:
 */public interface Showinterface {
    interface Showpresenter {
        void attchview(Showview Showview);

        void detachview();

        void getda();
    }
    interface  Showview{
        void Showview(String data);
    }
    interface  Showmodel{
        void Requset(Callback callback);

        interface Callback {
            void chenggong(String data);

            void shibsai();
        }
    }
}
