package com.jd.ganmingtao.demo.activityfragment.ui;

import android.databinding.Observable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.jd.ganmingtao.demo.FragmentsDemoBinding;
import com.jd.ganmingtao.demo.R;
import com.jd.ganmingtao.demo.activityfragment.viewmodel.FragmentsDemoActivityViewModel;
import com.jd.ganmingtao.jdmvvmframework.mvvm.aac.BaseViewModelFactory;
import com.jd.ganmingtao.jdmvvmframework.mvvm.commonview.ui.BaseBindingMvvmActivity;

/**Fragment示例activity
 *
 * @author ganmingtao
 * @date 2017/12/14
 */

public class FragmentsDemoActivity extends BaseBindingMvvmActivity<FragmentsDemoActivityViewModel, FragmentsDemoBinding> {
    /**
     * 属性变化回调
     */
    private Observable.OnPropertyChangedCallback mUserClickCallback;

    @Override
    protected int createLayout() {
        return R.layout.activity_fragments_demo;
    }

    /*@Override
    protected FragmentsDemoActivityViewModel createViewModel() {
        return new FragmentsDemoActivityViewModel(this.getApplication());
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getBinding() != null){
            getBinding().demonormalImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getViewModel() != null){
                        getViewModel().userClicked();
                    }
                }
            });
        }


        mUserClickCallback = new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                shortToast("点了第" + getViewModel().getuserClickedNum() + "下");
            }
        };
        if(getViewModel() != null){
            getViewModel().userClickNum.addOnPropertyChangedCallback(mUserClickCallback);
        }
    }

    @Override
    public Class getViewModelClass() {
        return FragmentsDemoActivityViewModel.class;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUserClickCallback != null && getViewModel() != null) {
            getViewModel().userClickNum.removeOnPropertyChangedCallback(mUserClickCallback);
        }
    }

    /**显示吐司
     * @param msg 显示文案
     */
    public void shortToast(String msg) {
        Toast.makeText(FragmentsDemoActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}
