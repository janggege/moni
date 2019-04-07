package com.example.lenovo.moni.mvp.Myinterface;

import java.util.Map;

/*Time:2019/4/4
 *Author:刘江
 *Description:
 */public interface Reginterface {
    interface Regpresentr {
        void attchview(Regview regview);

        void detachview();

        void getda(Map<String, String> list);
    }

    interface Regview {
        void Regvire(String data);
    }

    interface Regmodel {
        void Requset(Map<String, String> list, Callback callback);

        interface Callback {
            void chenggong(String data);

            void shibsai();
        }
    }
}
