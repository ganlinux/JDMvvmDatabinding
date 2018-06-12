package com.jd.ganmingtao.jdmvvmframework.mvvm.base;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;


/**activity基类
 * @author ganmingtao
 */
@SuppressLint("NewApi")
public class BaseActivity extends FragmentActivity{
    /**
     * tag名称
     */
    private final String TAG = BaseActivity.class.getSimpleName();

    /**
     * Handler
     */
    private Handler handler = new Handler();

    /**获取handler
     * @return handler
     */
    public Handler getHandler() {
        return handler;
    }
    /**
     * 统一 post 接口
     */
    public void post(final Runnable action) {
        if (BaseActivity.this.isFinishing()) {
            return;
        }
        handler.post(action);
    }

    /**
     * 统一 post 接口
     */
    public void post(final Runnable action, int delayMillis) {
        if (BaseActivity.this.isFinishing()) {
            return;
        }
        handler.postDelayed(action, delayMillis);
    }
}