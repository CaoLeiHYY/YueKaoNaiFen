package com.nababy.yuekaolianxi2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nababy.yuekaolianxi2.adapter.FenLeiAdapter;
import com.nababy.yuekaolianxi2.R;

import java.util.ArrayList;

/**
 * 类的用途
 *
 * @author 曹可新
 * @time Date
 */
public class FeiLeiFragment extends Fragment {

    private View view;
    private ArrayList<String> list;
    private RecyclerView fenlei_recyclerView;
    private FenLeiAdapter adapter;
    private ChuanZhi chuanZhi;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fenleifragment,null);
        fenlei_recyclerView = (RecyclerView) view.findViewById(R.id.fenlei_recyclerView);
        initView();
        return view;
    }

    private void initView() {
        //定义集合并向集合中添加数据
        initadd();
        //向适配器传值并将适配器设置给RecyclerView
        initShiPei();
        //点击事件
        dianji();
    }

    private void dianji() {
        adapter.setOnItemClickListener(new FenLeiAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                chuanZhi.onChuanZhi(position);
            }
        });
    }

    public interface ChuanZhi{
        void onChuanZhi(int position);
    }

    public void setChuanZhi(ChuanZhi chuanZhi) {
        this.chuanZhi = chuanZhi;
    }

    private void initShiPei() {
        Log.e("xxxcao",list.toString());
        fenlei_recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new FenLeiAdapter(list, getActivity());
        fenlei_recyclerView.setAdapter(adapter);
    }

    private void initadd() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("第"+i+"频道");
        }
    }

}
