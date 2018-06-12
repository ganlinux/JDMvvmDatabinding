package com.jd.ganmingtao.jdmvvmframework.mvvm.base;

import android.os.Bundle;

/**
 * @author ganmingtao
 */
public class BaseEvent {

    /**
     * 事件类型
     */
    private String eventType;

    /**
     * 消息
     */
    private String message;

    /**
     * bundle
     */
    private Bundle bundle;

    /**构造函数
     * @param type 类型
     */
    public BaseEvent(String type){
        this.eventType = type;
    }

    /**构造函数
     * @param type 类型
     * @param msg 消息
     */
    public BaseEvent(String type, String msg) {
        this.eventType = type;
        this.message = msg;
    }

    /**获取消息
     * @return 消息
     */
    public String getMessage() {
        return message;
    }

    /**获取类型
     * @return 类型
     */
    public String getType() {
        return eventType;
    }

    /**获取bundle
     * @return bundle
     */
    public Bundle getBundle() {
        return bundle;
    }

    /**设置bundle
     * @param bundle bundle
     */
    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }
}
