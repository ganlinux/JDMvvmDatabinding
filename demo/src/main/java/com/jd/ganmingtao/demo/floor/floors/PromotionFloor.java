package com.jd.ganmingtao.demo.floor.floors;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.view.ViewGroup;

import com.jd.ganmingtao.demo.R;
import com.jd.ganmingtao.demo.floor.floors.entity.PromotionEntity;
import com.jd.ganmingtao.jdmvvmframework.mvvm.floorview.BaseMvvmFloorView;

/**促销楼层
 *
 * @author ganmingtao
 * @date 2017/12/26
 */

public class PromotionFloor<FloorPromotionBinding> extends BaseMvvmFloorView {
    /**
     * 促销列表
     */
    public ObservableArrayList<String> promotionList = new ObservableArrayList<>();

    /**
     * 构造函数，务必继承实现
     *
     * @param context 上下文
     */
    public PromotionFloor(ViewGroup parent, Context context) {
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
        return R.layout.floor_promotion_layout;
    }

    @Override
    public void updateViewByData(Object entity) {
        if(entity != null && entity instanceof PromotionEntity){
            PromotionEntity promotionEntity = (PromotionEntity)entity;
            promotionList.clear();
            promotionList.addAll(promotionEntity.promotionList);
        }
    }
}
