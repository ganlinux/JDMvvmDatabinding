package com.jd.ganmingtao.demo.activityfragment.viewmodel;

import android.app.Application;
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
    public final ObservableField<String> pageTitle = new ObservableField<String>();
    /**
     * 用户点击数
     */
    public final ObservableField<Integer> userClickNum = new ObservableField<Integer>(0);

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
            pageTitle.set(getApplication().getString(R.string.text_fragment_demo_activity_title));
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
        userClickNum.set(userClickNum.get() + 1);
    }

    /**获取点击数
     * @return 点击数
     */
    public int getuserClickedNum() {
        return userClickNum.get();
    }
}
