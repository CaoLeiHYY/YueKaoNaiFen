package com.nababy.yuekaolianxi2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nababy.yuekaolianxi2.R;
import com.nababy.yuekaolianxi2.bean.JavaBean;

import org.xutils.x;

import java.util.ArrayList;

/**
 * 类的用途
 *
 * @author 曹可新
 * @time Date
 */
public class ShangPinAdapter extends RecyclerView.Adapter<ShangPinAdapter.MyShangPinHolder> {

    private Context context;
    private ArrayList<JavaBean.DataBean> list;

    public ShangPinAdapter(Context context, ArrayList<JavaBean.DataBean> list) {
        this.context = context;
        this.list = list;
        Log.e("xxxsss",list.toString());
    }

    @Override
    public MyShangPinHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.shangpin_item,null);
        MyShangPinHolder holder = new MyShangPinHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyShangPinHolder holder, int position) {
        x.image().bind(holder.shangpin_image,list.get(position).course_pic);
        holder.shangpin_text.setText(list.get(position).course_tname);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyShangPinHolder extends RecyclerView.ViewHolder{

        private final TextView shangpin_text;
        private final ImageView shangpin_image;

        public MyShangPinHolder(View itemView) {
            super(itemView);
            shangpin_image = (ImageView) itemView.findViewById(R.id.shangpin_image);
            shangpin_text = (TextView) itemView.findViewById(R.id.shangpin_name);
        }
    }
}
