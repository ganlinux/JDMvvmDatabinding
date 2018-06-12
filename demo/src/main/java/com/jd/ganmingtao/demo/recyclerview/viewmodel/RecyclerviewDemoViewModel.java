package com.jd.ganmingtao.demo.recyclerview.viewmodel;

import android.app.Application;
import android.databinding.ObservableField;
import com.jd.ganmingtao.demo.R;
import com.jd.ganmingtao.jdmvvmframework.mvvm.base.BaseEvent;
import com.jd.ganmingtao.jdmvvmframework.mvvm.commonview.vm.BaseViewModel;

/**Recyclerview示例ViewModel
 *
 * @author ganmingtao
 * @date 2017/12/14
 */

public class RecyclerviewDemoViewModel extends BaseViewModel {
    /**
     * 标题
     */
    public final ObservableField<String> pageTitle = new ObservableField<String>();

    /**构造函数
     * @param application 上下文
     */
    public RecyclerviewDemoViewModel(Application application) {
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
        if(getApplication() != null){
            pageTitle.set(getApplication().getString(R.string.text_recyclerview_demo_activity_title));
        }
    }

    @Override
    protected void onSuspend() {

    }

    @Override
    protected void onDetach() {

    }
}
