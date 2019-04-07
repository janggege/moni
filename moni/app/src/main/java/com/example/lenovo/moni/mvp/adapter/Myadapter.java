package com.example.lenovo.moni.mvp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.lenovo.moni.R;
import com.example.lenovo.moni.mvp.bean.Showdata1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Time:2019/4/4
 *Author:刘江
 *Description:
 */public class Myadapter extends RecyclerView.Adapter<Myadapter.Viewholder> {
    List<Showdata1.DataBean> data1;
    Context context;

    public Myadapter(List<Showdata1.DataBean> data1, Context context) {
        this.data1 = data1;
        this.context = context;
    }

    @NonNull
    @Override
    public Myadapter.Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.iteam, viewGroup, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Myadapter.Viewholder viewholder, final int i) {
        viewholder.shang.setText(data1.get(i).getSellerName());
        viewholder.shang1.setChecked(data1.get(i).isIschecked());
        viewholder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        final List<Showdata1.DataBean.ListBean> list = data1.get(i).getList();
        final Shngpinadapter shngpinadapter = new Shngpinadapter(list, context);
        viewholder.recyclerView.setAdapter(shngpinadapter);

        //商品   适配器的监听
        shngpinadapter.setChildListener(new Shngpinadapter.onChildListener() {
            @Override
            public void onChild() {
                if (groupListener != null) {
                    groupListener.onGroup(data1);
                }
                //声明  变量  为 true
                boolean ischecked = true;
                //遍历 商品 信息
                for (int j = 0; j < list.size(); j++) {
                    boolean ischecked1 = list.get(j).isIschecked();//获取商品的状态
                    if (!ischecked1) {//商品没有选中的话
                        ischecked = false; //把刚刚定义的变量设为false
                        break;
                    }
                }
                //通过商品状态 来改变商家状态
                viewholder.shang1.setChecked(ischecked);
                //通过商品状态 来改变商家状态
                data1.get(i).setIschecked(ischecked);


            }
        });
        //商家控制 商品   shang1是   商家的checkbox
        //给商家设置点击事件
        viewholder.shang1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 改变商家的状态
                viewholder.shang1.setChecked(viewholder.shang1.isChecked());
                // 改变商品的状态  调用 商品适配器内的  setCheckChild()方法
                shngpinadapter.setCheckChild(viewholder.shang1.isChecked());
            }
        });

    }

    @Override
    public int getItemCount() {
        Log.i("qqq",data1.size()+"");
        return data1.size();
    }


    public class Viewholder extends RecyclerView.ViewHolder {

        private final TextView shang;
        private final RecyclerView recyclerView;
        private final CheckBox shang1;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            shang = itemView.findViewById(R.id.shang);
            recyclerView = itemView.findViewById(R.id.recy1);
            shang1 = itemView.findViewById(R.id.scheckbox);
        }
    }

    public interface onGroupListener {
        void onGroup(List<Showdata1.DataBean> data1);
    }

    public onGroupListener groupListener;

    public void setGroupListener(onGroupListener groupListener) {
        this.groupListener = groupListener;
    }


}
