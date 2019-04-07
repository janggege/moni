package com.example.lenovo.moni.mvp.Myinterface;

import java.util.Map;

/*Time:2019/4/4
 *Author:刘江
 *Description:
 */public interface Logininterface {
    interface Loginpresenter {
        void attchview(Loginview loginview);

        void detachview();

        void getda(Map<String, String> list);
    }

    interface Loginview {
        void Loginview(String data);
    }

    interface Loginmodel {
        void Requset(Map<String, String> list, Callback callback);

        interface Callback {
            void chenggong(String data);

            void shibsai();
        }
    }
}
