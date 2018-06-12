package com.jd.ganmingtao.demo.recyclerview.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import com.jd.ganmingtao.demo.R;
import com.jd.ganmingtao.demo.RecyclerviewDemoBinding;
import com.jd.ganmingtao.demo.recyclerview.adapter.RecyclerviewDemoAdapter;
import com.jd.ganmingtao.demo.manager.SimulateDataManager;
import com.jd.ganmingtao.demo.recyclerview.viewmodel.RecyclerviewDemoViewModel;
import com.jd.ganmingtao.jdmvvmframework.mvvm.commonview.ui.BaseBindingMvvmActivity;

/**Recyclerview示例的Activity
 *
 * @author ganmingtao
 * @date 2017/12/14
 */

public class RecyclerviewDemoActivity extends BaseBindingMvvmActivity<RecyclerviewDemoViewModel, RecyclerviewDemoBinding> {
    @Override
    protected int createLayout() {
        return R.layout.activity_recyclerview_demo;
    }

    /*@Override
    protected RecyclerviewDemoViewModel createViewModel() {
        return new RecyclerviewDemoViewModel(this.getApplication());
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    @Override
    public Class getViewModelClass() {
        return RecyclerviewDemoViewModel.class;
    }

    /**
     * 初始化布局
     */
    void initView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        getBinding().recyclerviewTest.setLayoutManager(linearLayoutManager);
        RecyclerviewDemoAdapter recyclerviewDemoAdapter = new RecyclerviewDemoAdapter(this, SimulateDataManager.createListData());
        getBinding().recyclerviewTest.setAdapter(recyclerviewDemoAdapter);
    }
}
