package com.jd.ganmingtao.jdmvvmframework.mvvm.floorview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jd.ganmingtao.jdmvvmframework.mvvm.base.BaseActivity;

/**有数据绑定功能的楼层基类
 *
 * @author ganmingtao
 * @date 2017/4/10
 */

public abstract class BaseFloorView {
    /**
     * Tag
     */
    protected String TAG = "BaseFloorView";
    /**
     * 上下文
     */
    protected Context mContext;
    /**
     * 标志页面已经销毁
     */
    protected boolean mIsDestroy = false;
    /**
     * 最外层View 引用，该View 会被增加或者从主界面清除
     */
    protected ViewGroup mRootView;
    /**
     * 楼层layout id
     */
    protected  int mLayoutId;

    /**
     * 标志页面是否初始化成功
     */
    protected boolean mIsInit = false;

    /**
     * 初始化失败后返回 空
     */
    protected ViewGroup mEmptyView;

    /**
     * 楼层唯一tag
     */
    public String tag;

    /**
     * 是否使用绑定功能
     */
    public boolean isUseDatabinding = false;
    /**
     * 构造函数，务必继承实现
     */
    public BaseFloorView(ViewGroup parent, Context context, boolean isUseDatabinding){
        this.isUseDatabinding = isUseDatabinding;
        this.mContext = context;
        this.mLayoutId = getLayoutId();
        if(!isUseDatabinding){
            try{

                if(mRootView == null && mLayoutId != 0){
                    mRootView = (ViewGroup) getLayoutInflater(mContext).inflate(mLayoutId, parent, false);
                }
                mIsInit = true;
            }catch (Exception e){

            }
        }
    }

    /**构造方法
     * @param parent 父布局
     * @param context 上下文
     */
    public BaseFloorView(ViewGroup parent, Context context){
        this(parent, context, false);
    }

    protected static LayoutInflater getLayoutInflater(Context context) {
        return (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    /**
     * 返回根RootView
     * @return 根RootView
     */
    public View getView(){
        if(!mIsInit){//这行代码应该不会执行到，如果执行到这里，
            if(mEmptyView == null){
                mEmptyView = new LinearLayout(mContext);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                mEmptyView.setLayoutParams(params);
            }
            mRootView = mEmptyView;
        }
        mRootView.setBackgroundColor(Color.parseColor("#ffffff"));
        return mRootView;
    }

    /**
     * 页面销毁的时候会调用该方法执行销毁逻辑
     */
    public void onDestroy() {
        mIsDestroy = true;
        onDestroyView();
        if(mRootView != null){
            mRootView.setTag(null);
        }
        mRootView = null;
        mContext = null;
    }

    /**
     * 发布消息
     * @param action
     */
    public void post(Runnable action){
        if(mContext != null && mContext instanceof BaseActivity){
            ((BaseActivity)mContext).post(action);
        }
    }

    /**
     * 发布延迟消息
     * @param action
     * @param delay 延迟消息
     */
    public void post(Runnable action, int delay){
        if(mContext != null && mContext instanceof BaseActivity){
            ((BaseActivity)mContext).post(action, delay);
        }
    }

    /**
     * 隐藏掉这个这个楼层
     */
    protected abstract void hideFloor();

    /**
     * 重写该方法，方便编码
     * @return
     */
    public Resources getResources(){
        return mContext.getResources();
    }

    /**
     * 销毁页面的逻辑，主要是删除常量强引用，变量代码赋空等
     */
    protected abstract void onDestroyView();

    /**
     * 设置楼层layout id
     */
    protected abstract int getLayoutId();
    /**
     * 更新楼层数据
     */
    public abstract void updateViewByData(Object entity);
}
