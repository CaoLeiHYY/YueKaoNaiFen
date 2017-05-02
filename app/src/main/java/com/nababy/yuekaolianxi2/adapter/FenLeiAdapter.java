package com.nababy.yuekaolianxi2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nababy.yuekaolianxi2.R;

import java.util.ArrayList;

/**
 * 类的用途
 *
 * @author 曹可新
 * @time Date
 */
public class FenLeiAdapter extends RecyclerView.Adapter<FenLeiAdapter.MyFenleiHolder> {

    private Context context;
    private ArrayList<String> list;
    //声明接口
    public OnItemClickListener itemClickListener;
    public OnItemLongClickListener itemLongClickListener;

    //定义条目点击事件
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    //定义条目的长按事件
    public interface OnItemLongClickListener {
        void onItemLongClick(View view, int position);
    }

    //对外提供两个访问的set方法
    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public FenLeiAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
        Log.e("xxx",list.toString());
    }

    @Override
    public MyFenleiHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.fenlei_item,null);
        final MyFenleiHolder holder = new MyFenleiHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getLayoutPosition();
                //注册点击监听
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(v, position);
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(MyFenleiHolder holder, int position) {
        holder.item_name.setText(list.get(position));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyFenleiHolder extends RecyclerView.ViewHolder{

        private final TextView item_name;

        public MyFenleiHolder(View itemView) {
            super(itemView);
            item_name = (TextView) itemView.findViewById(R.id.fenlei_item_name);
        }
    }
}
