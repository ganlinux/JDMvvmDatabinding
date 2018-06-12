package com.jd.ganmingtao.jdmvvmframework.mvvm.floorview;

/**
 *
 * 楼层管理器实体类，服务器下发
 * @author ganmingtao
 */
public class FloorEntity {
    /**
     * 楼层模板类型，标志不同的模板
     */
    public int floorType;
    /**
     * 服务器下发的id
     */
    public String mId;
    /**
     * 楼层业务类型
     */
    public String floorBusiness;

    /**
     * 是否加入楼层, 默认加入
     */
    public boolean isAddToFloor = false;

    /**
     * 需要显示的数据
     */
    public Object mData;

    /**
     * 构造函数
     */
    public FloorEntity(){

    }

    /**构造函数
     * @param floorType 楼层类型
     */
    public FloorEntity(int floorType){
        this.floorType = floorType;
    }

    /**构造函数
     * @param floorType 楼层类型
     * @param floorBusiness 楼层业务类型
     */
    public FloorEntity(int floorType, String floorBusiness){
        this.floorType = floorType;
        this.floorBusiness = floorBusiness;
    }

    /**
     * 添加楼层
     */
    public void addToFloor(){
        isAddToFloor = true;
    }

}
