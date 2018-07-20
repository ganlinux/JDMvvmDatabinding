package com.jd.ganmingtao.demo.activityfragment.viewmodel;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.view.View;

import com.jd.ganmingtao.demo.R;
import com.jd.ganmingtao.jdmvvmframework.mvvm.base.BaseEvent;
import com.jd.ganmingtao.jdmvvmframework.mvvm.commonview.vm.BaseViewModel;

/**
 * fragment示例viewmodel
 * @author ganmingtao
 * @date 2017/12/15
 */

public class DemoNormalFragmentViewModel extends BaseViewModel {
    /**
     * button1显示状态
     */
    public final MutableLiveData<Integer> button1Visibility = new MutableLiveData<>();
    /**
     * button2显示状态
     */
    public final MutableLiveData<Integer> button2Visibility = new MutableLiveData<>();
    /**
     * fragment标题
     */
    public final MutableLiveData<String> fragmentTitle = new MutableLiveData<>();

    /**构造函数
     * @param application 上下文
     */
    public DemoNormalFragmentViewModel(Application application) {
        super(application);
    }

    @Override
    public void onEvent(BaseEvent event) {

    }

    @Override
    public void onEventMainThread(BaseEvent event) {

    }

    @Override
    protected void onAttach() {
        fragmentTitle.postValue(getApplication().getString(R.string.text_demo_normal_fragment_title));
    }

    @Override
    protected void onSuspend() {

    }

    @Override
    protected void onDetach() {

    }

    /**
     * 点击刷新用户数据事件
     */
    public void button1OnClick(View view)
    {
        button1Visibility.postValue(View.INVISIBLE);
        button2Visibility.postValue(View.VISIBLE);
    }
    /**
     * 点击刷新用户数据事件
     */
    public void button2OnClick(View view)
    {
        button1Visibility.postValue(View.VISIBLE);
        button2Visibility.postValue(View.INVISIBLE);
    }
}
