package com.jd.ganmingtao.demo.manager;

import com.jd.ganmingtao.demo.floor.floors.entity.CouponEntity;
import com.jd.ganmingtao.demo.floor.floors.entity.PriceNormalEntity;
import com.jd.ganmingtao.demo.floor.floors.entity.ProductNameEntity;
import com.jd.ganmingtao.demo.floor.floors.entity.PromotionEntity;
import com.jd.ganmingtao.demo.recyclerview.entity.ProductEntity;
import com.jd.ganmingtao.demo.floor.floors.entity.AddressEntity;
import com.jd.ganmingtao.demo.floor.floors.entity.BigImageEntity;
import com.jd.ganmingtao.jdmvvmframework.mvvm.floorview.FloorEntity;
import java.util.ArrayList;

/**模拟数据生成器
 *
 * @author ganmingtao
 * @date 2017/5/8
 */
public class SimulateDataManager {
    /**创建列表数据
     * @return 列表数据
     */
    public static ArrayList<ProductEntity> createListData(){
        ArrayList< ProductEntity > productEntityArrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ProductEntity productEntity = new ProductEntity();
            productEntity.imageUrl = "http://m.360buyimg.com//mobilecms/s558x558_jfs/t3535/44/1658435222/205690/6538fbf8/582d428aN93adcba8.jpg!q70.jpg";
            productEntity.price = "12元";
            productEntity.num = "x1";
            productEntity.name = "商品" + i;
            productEntityArrayList.add(productEntity);
        }
        return productEntityArrayList;
    }

    /**创建楼层数据
     * @return 楼层数据
     */
    public static ArrayList<FloorEntity> createFloorsData(){
        //大图
        ArrayList< FloorEntity > productEntityArrayList = new ArrayList<>();
        FloorEntity bigImageFloorEntity = new FloorEntity();
        bigImageFloorEntity.floorType = 0;
        BigImageEntity bigImageEntity = new BigImageEntity();
        bigImageEntity.url = "http://m.360buyimg.com//mobilecms/s558x558_jfs/t3535/44/1658435222/205690/6538fbf8/582d428aN93adcba8.jpg!q70.jpg";
        bigImageFloorEntity.mData = bigImageEntity;
        productEntityArrayList.add(bigImageFloorEntity);

        //商品名称
        FloorEntity productNameFloorEntity = new FloorEntity();
        productNameFloorEntity.floorType = 1;
        ProductNameEntity productNameEntity = new ProductNameEntity();
        productNameEntity.name = "大吸力油烟机";
        productNameFloorEntity.mData = productNameEntity;
        productEntityArrayList.add(productNameFloorEntity);

        //价格
        FloorEntity priceFloorEntity = new FloorEntity();
        priceFloorEntity.floorType = 2;
        PriceNormalEntity priceNormalEntity = new PriceNormalEntity();
        priceNormalEntity.price = "¥12";
        priceFloorEntity.mData = priceNormalEntity;
        productEntityArrayList.add(priceFloorEntity);

        //地址
        FloorEntity addressFloorEntity = new FloorEntity();
        addressFloorEntity.floorType = 3;
        AddressEntity addressEntity1 = new AddressEntity();
        addressEntity1.address = "北京市朝阳区xxxxxxx";
        addressFloorEntity.mData = addressEntity1;
        productEntityArrayList.add(addressFloorEntity);

        //促销
        FloorEntity promotionFloorEntity = new FloorEntity();
        promotionFloorEntity.floorType = 4;
        PromotionEntity promotionEntity = new PromotionEntity();
        ArrayList<String> promotionList = new ArrayList<>();
        promotionList.add("套装");
        promotionList.add("满1000-100");
        promotionList.add("赠品");
        promotionEntity.promotionList = promotionList;
        promotionFloorEntity.mData = promotionEntity;
        productEntityArrayList.add(promotionFloorEntity);

        //优惠券
        FloorEntity couponFloorEntity = new FloorEntity();
        couponFloorEntity.floorType = 5;
        CouponEntity couponEntity = new CouponEntity();
        couponEntity.couponName = "500元-50";
        couponFloorEntity.mData = couponEntity;
        productEntityArrayList.add(couponFloorEntity);

        return productEntityArrayList;
    }
}
