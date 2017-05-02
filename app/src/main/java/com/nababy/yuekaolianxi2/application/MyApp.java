package com.nababy.yuekaolianxi2.application;

import android.app.Application;

import org.xutils.x;

/**
 * 类的用途
 *
 * @author 曹可新
 * @time Date
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
