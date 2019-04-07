package com.example.lenovo.moni.mvp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.moni.R;
import com.example.lenovo.moni.activity.Myview;
import com.example.lenovo.moni.mvp.bean.Showdata1;

import java.util.List;

/*Time:2019/4/4
 *Author:刘江
 *Description:
 */public class Shngpinadapter extends RecyclerView.Adapter<Shngpinadapter.Viewholder> {
    List<Showdata1.DataBean.ListBean> list;
    Context context;


    public Shngpinadapter(List<Showdata1.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Shngpinadapter.Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.siteam, viewGroup, false);
        return new Viewholder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull final Shngpinadapter.Viewholder viewholder, final int i) {
        viewholder.name.setText(list.get(i).getTitle());
        viewholder.price.setText(list.get(i).getPrice() + "");
        viewholder.checkBox.setChecked(list.get(i).isIschecked());
        Glide.with(context).load(list.get(i).getImages()).into(viewholder.imageView);
        //自定义view；
        viewholder.myview.setData(this, list, i);
        viewholder.myview.setNumChangeListener(new Myview.onNumChangeListener() {
            @Override
            public void onResult() {
                if (childListener != null) {
                    childListener.onChild();
                }
            }
        });
        //商品状态  改变
        viewholder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (childListener != null) {
                    list.get(i).setIschecked(b); //b或  true   或   false  因为在 onchengchenckdechangelisnenert
                    childListener.onChild();
                }
            }

        });


    }

    //设置商品的状态
    public void setCheckChild(boolean checked) {
        //商家适配器调用次方法
        //通过该方法实现商家内部商品全选
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setIschecked(checked);
        }
        //设置完状态  刷新适配器
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView price;
        private final ImageView imageView;
        private final CheckBox checkBox;
        private final Myview myview;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.sname);
            price = itemView.findViewById(R.id.sprice);
            imageView = itemView.findViewById(R.id.simage);
            checkBox = itemView.findViewById(R.id.pchenckbox);
            myview = itemView.findViewById(R.id.myview);
        }
    }

    public interface onChildListener {
        void onChild();
    }

    public onChildListener childListener;

    public void setChildListener(onChildListener childListener) {
        this.childListener = childListener;
    }


}
