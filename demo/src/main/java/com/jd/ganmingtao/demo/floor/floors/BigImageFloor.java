package com.jd.ganmingtao.demo.floor.floors;

import android.content.Context;
import android.databinding.ObservableField;
import android.view.ViewGroup;

import com.jd.ganmingtao.demo.R;
import com.jd.ganmingtao.demo.floor.floors.entity.BigImageEntity;
import com.jd.ganmingtao.jdmvvmframework.mvvm.floorview.BaseMvvmFloorView;

/**大图楼层
 *
 * @author ganmingtao
 * @date 2017/12/26
 */

public class BigImageFloor<FloorBigImageBinding> extends BaseMvvmFloorView {
    /**
     * 图片url
     */
    public ObservableField<String> urlString = new ObservableField<>();

    /**
     * 构造函数，务必继承实现
     *
     * @param context
     */
    public BigImageFloor(ViewGroup parent, Context context) {
        super(parent, context);
    }


    @Override
    protected void hideFloor() {

    }

    @Override
    protected void onDestroyView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.floor_bigimage_layout;
    }

    @Override
    public void updateViewByData(Object entity) {
        if(entity != null && entity instanceof BigImageEntity){
            BigImageEntity bigImageEntity = (BigImageEntity)entity;
            urlString.set(bigImageEntity.url);
        }
    }
}
