package com.jd.ganmingtao.demo.activityfragment.viewmodel;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;

import com.jd.ganmingtao.demo.R;
import com.jd.ganmingtao.jdmvvmframework.mvvm.base.BaseEvent;
import com.jd.ganmingtao.jdmvvmframework.mvvm.commonview.vm.BaseViewModel;

/**fragment示例activity viewmodel
 *
 * @author ganmingtao
 * @date 2017/12/14
 */

public class FragmentsDemoActivityViewModel extends BaseViewModel {
    /**
     * 标题
     */
    public final MutableLiveData<String> pageTitle = new MutableLiveData<>();
    /**
     * 用户点击数
     */
    public final MutableLiveData<Integer> userClickNum = new MutableLiveData<>();

    /**构造函数
     * @param application 上下文
     */
    public FragmentsDemoActivityViewModel(Application application) {
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
            pageTitle.postValue(getApplication().getString(R.string.text_fragment_demo_activity_title));
    }

    @Override
    protected void onSuspend() {

    }

    @Override
    protected void onDetach() {

    }

    /**
     * 点击处理
     */
    // TODO: 2017/12/28 此处有坑  userClickNum未初始化 userClickNum.get() == null
    public void userClicked(){
        userClickNum.postValue(userClickNum.getValue() + 1);
    }

    /**获取点击数
     * @return 点击数
     */
    public int getuserClickedNum() {
        return userClickNum.getValue();
    }
}
