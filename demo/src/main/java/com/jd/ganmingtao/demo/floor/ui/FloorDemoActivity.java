package com.jd.ganmingtao.demo.floor.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;
import com.jd.ganmingtao.demo.FloorDemoBinding;
import com.jd.ganmingtao.demo.R;
import com.jd.ganmingtao.demo.floor.FloorDemoAdapter;
import com.jd.ganmingtao.demo.manager.SimulateDataManager;
import com.jd.ganmingtao.demo.floor.viewmodel.FloorDemoViewModel;
import com.jd.ganmingtao.jdmvvmframework.mvvm.commonview.ui.BaseBindingMvvmActivity;

/**楼层示例activity
 *
 * @author ganmingtao
 * @date 2017/12/14
 */

public class FloorDemoActivity extends BaseBindingMvvmActivity<FloorDemoViewModel, FloorDemoBinding> {

    @Override
    protected int createLayout() {
        return R.layout.activity_floor_demo;
    }

    @Override
    protected FloorDemoViewModel createViewModel() {
        return new FloorDemoViewModel(this.getApplication());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    /**
     * 初始化布局
     */
    void initView(){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        getBinding().recyclerviewTest.setLayoutManager(linearLayoutManager);
        FloorDemoAdapter recyclerviewDemoAdapter = new FloorDemoAdapter(this, SimulateDataManager.createFloorsData());
        getBinding().recyclerviewTest.setAdapter(recyclerviewDemoAdapter);
    }

    /**显示toast
     * @param msg 文案
     */
    public void shortToast(String msg) {
        Toast.makeText(FloorDemoActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}
