package com.jd.ganmingtao.demo.floor.floors;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jd.ganmingtao.demo.R;
import com.jd.ganmingtao.demo.floor.floors.entity.PriceNormalEntity;
import com.jd.ganmingtao.jdmvvmframework.mvvm.floorview.BaseFloorView;

/**价格非Binding楼层
 *
 * @author ganmingtao
 * @date 2017/12/26
 */

public class PriceNormalFloor extends BaseFloorView {
    /**
     *价格
     */
    private TextView price;
    /**
     * 构造函数，务必继承实现
     *
     * @param context 上下文
     */
    public PriceNormalFloor(ViewGroup parent, Context context) {
        super(parent, context);
        price = (TextView)mRootView.findViewById(R.id.price);
    }


    @Override
    protected void hideFloor() {

    }

    @Override
    protected void onDestroyView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.floor_pricenormal_layout;
    }

    @Override
    public void updateViewByData(Object entity) {
        if(entity != null && entity instanceof PriceNormalEntity){
            PriceNormalEntity priceNormalEntity = (PriceNormalEntity)entity;
            price.setText(priceNormalEntity.price);
        }
    }
}
