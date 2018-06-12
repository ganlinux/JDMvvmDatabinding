package com.jd.ganmingtao.jdmvvmframework.mvvm.base;

import de.greenrobot.event.EventBus;

/**
 * @author ganmingtao
 */
public abstract class BaseInteractor {

    public void postEvent(BaseEvent event) {
        EventBus.getDefault().post(event);
    }

    /**
     * 用于取消联网请求，或停止数据的读写
     */
    public abstract void cancleIO();
    /**
     * 释放资源，根据onTrimMemory(int level)接口，制定更好的缓存回收策略
     * @param level 定义回收等级
     */
    public abstract void clearState(int level);

}
