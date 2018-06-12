package com.jd.ganmingtao.demo.floor;

import android.content.Context;
import android.view.ViewGroup;

import com.jd.ganmingtao.demo.floor.floors.AddressFloor;
import com.jd.ganmingtao.demo.floor.floors.BigImageFloor;
import com.jd.ganmingtao.demo.floor.floors.CouponFloor;
import com.jd.ganmingtao.demo.floor.floors.PriceNormalFloor;
import com.jd.ganmingtao.demo.floor.floors.ProductNameFloor;
import com.jd.ganmingtao.demo.floor.floors.PromotionFloor;
import com.jd.ganmingtao.jdmvvmframework.mvvm.floorview.BaseFloorView;
import com.jd.ganmingtao.jdmvvmframework.mvvm.floorview.FloorEntity;
import com.jd.ganmingtao.jdmvvmframework.mvvm.floorview.FloorRecyclerviewBaseAdapter;
import java.util.ArrayList;

/**Recyclerview示例的适配器
 *
 * @author ganmingtao
 * @date 2017/12/25
 */

public class FloorDemoAdapter extends FloorRecyclerviewBaseAdapter {
    /**构造函数
     * @param context 上下文
     * @param mCreateFloors 楼层列表
     */
    public FloorDemoAdapter(Context context, ArrayList<FloorEntity> mCreateFloors) {
        super(context, mCreateFloors);
    }

    @Override
    public BaseFloorView createFloor(ViewGroup parent, int viewType) {
        BaseFloorView baseMvvmFloorView = null;
        switch (viewType){
            //大图
            case 0:
                baseMvvmFloorView = new BigImageFloor(parent, context);
                break;
            //商品名称
            case 1:
                baseMvvmFloorView = new ProductNameFloor(parent, context);
                break;
            //价格
            case 2:
                baseMvvmFloorView = new PriceNormalFloor(parent, context);
                break;
            //地址
            case 3:
                baseMvvmFloorView = new AddressFloor(parent, context);
                break;
            //促销
            case 4:
                baseMvvmFloorView = new PromotionFloor(parent, context);
                break;
            //优惠券
            case 5:
                baseMvvmFloorView = new CouponFloor(parent, context);
                break;
            default:
                break;
        }
        return baseMvvmFloorView;
    }
}
