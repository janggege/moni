package com.example.lenovo.moni.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.lenovo.moni.R;
import com.example.lenovo.moni.mvp.Myinterface.Showinterface;
import com.example.lenovo.moni.mvp.adapter.Myadapter;
import com.example.lenovo.moni.mvp.bean.Showdata1;
import com.example.lenovo.moni.mvp.presenter.Showpresentre;
import com.google.gson.Gson;

import java.util.List;

/*Time:2019/4/4
 *Author:刘江
 *Description:
 */public class Shouye extends Fragment implements Showinterface.Showview, View.OnClickListener {
    private Handler handler = new Handler();
    private RecyclerView recyclerView;
    private CheckBox quan;
    private Myadapter myadapter;
    private List<Showdata1.DataBean> data1;
    private TextView jiage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shouye, container, false);
        recyclerView = view.findViewById(R.id.recy);
        quan = view.findViewById(R.id.quan);
        jiage = view.findViewById(R.id.jiage);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        Showpresentre showpresentre = new Showpresentre();
        showpresentre.attchview(this);
        showpresentre.getda();
        quan.setOnClickListener(this);
        return view;
    }


    @Override
    public void Showview(final String data) {
        Log.i("qqq",data.length()+"");
        handler.post(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                Showdata1 showdata = gson.fromJson(data, Showdata1.class);
                data1 = showdata.getData();
                myadapter = new Myadapter(data1, getActivity());
                recyclerView.setAdapter(myadapter);
                shangjia();
            }
        });
    }

    private void shangjia() {//商家控制全选
        myadapter.setGroupListener(new Myadapter.onGroupListener() {
            @Override
            public void onGroup(List<Showdata1.DataBean> data1) {
                int price = 0; //这是一个价格
                int num1 = 0;//商品得数量
                int num2 = 0;//商品选中数量
                for (int i = 0; i < data1.size(); i++) {
                    List<Showdata1.DataBean.ListBean> list = data1.get(i).getList();
                    for (int j = 0; j < list.size(); j++) {   //商品
                        num1++; //商品数量++
                        boolean ischecked = list.get(j).isIschecked();//商品的状态
                        if (ischecked) {//如果 商品的状态为  true的话
                            num2++;  //就把商品选中的数量  ++
                            //计算选中商品的价格
                            price += data1.get(i).getList().get(j).getNum() * data1.get(i).getList().get(j).getPrice();
                        }
                    }
                }
                //在循坏外面判断 如果商品的数量==选中商品的数量
                if (num1 == num2) {
                    quan.setChecked(true);//把全选的checkbox 设置为true
                } else {       //把全选的checkbox 设置为false
                    quan.setChecked(false);
                }
                //设置价格
                jiage.setText(price + "");
            }
        });
    }

    //全选 /反选的点击事件
    @Override
    public void onClick(View view) {

        setOntListChick(quan.isChecked());
}

    //全选 /反选
    private void setOntListChick(boolean checked) {
        int prices = 0;//价格
        if (checked) {//如果 全选checkbox为 true的话
            for (int i = 0; i < data1.size(); i++) {  //就把  商家 循环  便利
                data1.get(i).setIschecked(true);//    设为true
                for (int j = 0; j < data1.get(i).getList().size(); j++) {//商品 循环  便利
                    //商品也设为 true
                    data1.get(i).getList().get(j).setIschecked(true);
                    // //如果  商品为true的true的话计算价格
                    prices += data1.get(i).getList().get(j).getNum() * data1.get(i).getList().get(j).getPrice();
                }
            }

        } else {//  如果   全选的CheckBox为false的话
            for (int i = 0; i < data1.size(); i++) {//遍历商家
                //遍历商家 设为 false
                data1.get(i).setIschecked(false);
                for (int j = 0; j < data1.get(i).getList().size(); j++) {
                    //遍历商品 设为 false
                    data1.get(i).getList().get(j).setIschecked(false);
                }
            }

        }
        //刷新适配器
        myadapter.notifyDataSetChanged();
        //这边是给价格 赋值
        jiage.setText(prices + "");
    }


}
