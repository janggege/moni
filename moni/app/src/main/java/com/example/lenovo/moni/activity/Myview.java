package com.example.lenovo.moni.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lenovo.moni.R;
import com.example.lenovo.moni.mvp.adapter.Shngpinadapter;
import com.example.lenovo.moni.mvp.bean.Showdata1;

import java.util.List;

/*
  name:刘江
  data:2019
*/public class Myview extends LinearLayout implements View.OnClickListener {

    private EditText ed;
    private int numbre;  //自定义一个numbre
    private List<Showdata1.DataBean.ListBean> list;
    private Shngpinadapter childAdapter;
    private int i;
    Context context;


    public Myview(Context context) {
        super(context);
    }

    public Myview(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initview(context);
    }


    public Myview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initview(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.myview2, null, false);
        addView(view);
        view.findViewById(R.id.jia).setOnClickListener(this);
        view.findViewById(R.id.jian).setOnClickListener(this);
        ed = view.findViewById(R.id.ed1);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jia:  //加
                numbre++;    //numbre++;
                ed.setText(numbre + ""); // 给设置值
                list.get(i).setNum(numbre); //给   商品里面的num，设置新++过后的值
                if (numChangeListener != null) {
                    numChangeListener.onResult();
                }
                childAdapter.notifyDataSetChanged();//刷新 商品


                break;
            case R.id.jian:    //减
                numbre--;   //numbre--
                if (numbre < 1) {  //   numbre小于 1的时候
                    Toast.makeText(context, "不能再减了", Toast.LENGTH_SHORT).show();
                    numbre = 1;
                } else {
                    ed.setText(numbre + "");
                    list.get(i).setNum(numbre);
                    numChangeListener.onResult();
                    childAdapter.notifyDataSetChanged();
                }

                break;

        }
    }

    //商品适配器调用的方法
    public void setData(Shngpinadapter childAdapter, List<Showdata1.DataBean.ListBean> list, int i) {
        this.childAdapter = childAdapter;
        this.list = list;
        this.i = i;
        numbre = list.get(i).getNum();
        ed.setText(list.get(i).getNum() + "");
    }


    public interface onNumChangeListener {
        void onResult();
    }

    public onNumChangeListener numChangeListener;

    public void setNumChangeListener(onNumChangeListener numChangeListener) {
        this.numChangeListener = numChangeListener;
    }

}
