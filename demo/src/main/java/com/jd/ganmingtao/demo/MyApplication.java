package com.jd.ganmingtao.demo;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 *
 * @author ganmingtao
 * @date 2017/12/25
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
