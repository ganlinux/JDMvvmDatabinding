package com.jd.ganmingtao.demo.floor.floors;

import android.content.Context;
import android.databinding.ObservableField;
import android.view.ViewGroup;

import com.jd.ganmingtao.demo.R;
import com.jd.ganmingtao.demo.floor.floors.entity.CouponEntity;
import com.jd.ganmingtao.jdmvvmframework.mvvm.floorview.BaseMvvmFloorView;

/**优惠券楼层
 *
 * @author ganmingtao
 * @date 2017/12/26
 */

public class CouponFloor<FloorCouponBinding> extends BaseMvvmFloorView {
    /**
     * 优惠券名称
     */
    public ObservableField<String> couponName = new ObservableField<>();

    /**
     * 构造函数，务必继承实现
     *
     * @param context 上下文
     */
    public CouponFloor(ViewGroup parent, Context context) {
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
        return R.layout.floor_coupon_layout;
    }

    @Override
    public void updateViewByData(Object entity) {
        if(entity != null && entity instanceof CouponEntity){
            CouponEntity couponEntity = (CouponEntity)entity;
            couponName.set(couponEntity.couponName);
        }
    }
}
