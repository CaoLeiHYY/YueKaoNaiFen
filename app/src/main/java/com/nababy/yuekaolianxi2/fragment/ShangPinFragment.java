package com.nababy.yuekaolianxi2.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.nababy.yuekaolianxi2.R;
import com.nababy.yuekaolianxi2.adapter.ShangPinAdapter;
import com.nababy.yuekaolianxi2.bean.JavaBean;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 类的用途
 *
 * @author 曹可新
 * @time Date
 */
public class ShangPinFragment extends Fragment {

    private View view;
    private RecyclerView shangpin_recyclerView;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0){
                String json = (String) msg.obj;
                Gson gson = new Gson();
                JavaBean bean = gson.fromJson(json, JavaBean.class);
                final ArrayList<JavaBean.DataBean> list = bean.datalist;
                shangpin_recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
                ShangPinAdapter adapter = new ShangPinAdapter(getActivity(),list);
                shangpin_recyclerView.setAdapter(adapter);
                FeiLeiFragment fragment = (FeiLeiFragment) getFragmentManager().findFragmentById(R.id.fenlei_fragment);
                fragment.setChuanZhi(new FeiLeiFragment.ChuanZhi() {
                    @Override
                    public void onChuanZhi(int position) {
                        ArrayList<JavaBean.DataBean> list1 = new ArrayList<JavaBean.DataBean>();
                        list1.add(list.get(position));
                        shangpin_recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
                        ShangPinAdapter adapter = new ShangPinAdapter(getActivity(),list1);
                        shangpin_recyclerView.setAdapter(adapter);
                    }
                });
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.hangpinfragment,null);
        shangpin_recyclerView = (RecyclerView) view.findViewById(R.id.shangpin_recyclerView);
        //请求数据，封装集合
        initDatas();
        return view;
    }

    private void initDatas() {
        String url = "http://www.meirixue.com/api.php?c=list&a=index";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String json = response.body().string();
                Message message = Message.obtain(handler,0,json);
                message.sendToTarget();
            }
        });
    }
}
