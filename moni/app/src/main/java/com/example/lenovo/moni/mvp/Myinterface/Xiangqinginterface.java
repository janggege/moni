package com.example.lenovo.moni.mvp.Myinterface;

/*Time:2019/4/4
 *Author:刘江
 *Description:
 */public interface Xiangqinginterface {
    interface Xiangqingpresentr {
        void attchview(Xiangqingview Xiangqingview);

        void detachview();

        void getda(int pid);
    }

    interface Xiangqingview {
        void Xianagqingview(String data);
    }

    interface Xiangqingmodel {
        void Requset( int pid,Callback callback);

        interface Callback {
            void chenggong(String data);

            void shibsai();
        }
    }
}
