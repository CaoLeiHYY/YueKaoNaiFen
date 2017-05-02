package com.nababy.yuekaolianxi2.bean;

import java.util.ArrayList;

/**
 * 类的用途
 *
 * @author 曹可新
 * @time Date
 */
public class JavaBean {
    public int count;
    public int limit;
    public int curpage;
    public ArrayList<DataBean> datalist;
    public class DataBean{
        public String cid;
        public String course_tname;
        public String course_name;
        public String course_price;
        public String course_pic;
        public String course_paycount;
        public String school_name;

        @Override
        public String toString() {
            return "DataBean{" +
                    "cid='" + cid + '\'' +
                    ", course_tname='" + course_tname + '\'' +
                    ", course_name='" + course_name + '\'' +
                    ", course_price='" + course_price + '\'' +
                    ", course_pic='" + course_pic + '\'' +
                    ", course_paycount='" + course_paycount + '\'' +
                    ", school_name='" + school_name + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "JavaBean{" +
                "count=" + count +
                ", limit=" + limit +
                ", curpage=" + curpage +
                ", datalist=" + datalist +
                '}';
    }
}
