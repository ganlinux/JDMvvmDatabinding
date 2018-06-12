package com.jd.ganmingtao.demo.floor.floors;

import android.content.Context;
import android.databinding.ObservableField;
import android.view.ViewGroup;

import com.jd.ganmingtao.demo.R;
import com.jd.ganmingtao.demo.floor.floors.entity.AddressEntity;
import com.jd.ganmingtao.jdmvvmframework.mvvm.floorview.BaseMvvmFloorView;

/**地址楼层
 *
 * @author ganmingtao
 * @date 2017/12/26
 */

public class AddressFloor<FloorAddressBinding> extends BaseMvvmFloorView {
    /**
     * 地址
     */
    public ObservableField<String> addressString = new ObservableField<>();

    /**
     * 构造函数，务必继承实现
     *
     * @param context 上下文
     */
    public AddressFloor(ViewGroup parent, Context context) {
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
        return R.layout.floor_address_layout;
    }

    @Override
    public void updateViewByData(Object entity) {
        if(entity != null && entity instanceof AddressEntity){
            AddressEntity addressEntity = (AddressEntity)entity;
            addressString.set(addressEntity.address);
        }
    }
}
