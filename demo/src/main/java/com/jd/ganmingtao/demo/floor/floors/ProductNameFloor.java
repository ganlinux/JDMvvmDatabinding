package com.jd.ganmingtao.demo.floor.floors;

import android.content.Context;
import android.databinding.ObservableField;
import android.view.ViewGroup;

import com.jd.ganmingtao.demo.R;
import com.jd.ganmingtao.demo.floor.floors.entity.ProductNameEntity;
import com.jd.ganmingtao.jdmvvmframework.mvvm.floorview.BaseMvvmFloorView;

/**商品名称楼层
 *
 * @author ganmingtao
 * @date 2017/12/26
 */

public class ProductNameFloor<FloorBigImageBinding> extends BaseMvvmFloorView {
    /**
     * 名称
     */
    public ObservableField<String> productNameString = new ObservableField<>();

    /**
     * 构造函数，务必继承实现
     *
     * @param context 上下文
     */
    public ProductNameFloor(ViewGroup parent, Context context) {
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
        return R.layout.floor_productname_layout;
    }

    @Override
    public void updateViewByData(Object entity) {
        if(entity != null && entity instanceof ProductNameEntity){
            ProductNameEntity productNameEntity = (ProductNameEntity)entity;
            productNameString.set(productNameEntity.name);
        }
    }
}
