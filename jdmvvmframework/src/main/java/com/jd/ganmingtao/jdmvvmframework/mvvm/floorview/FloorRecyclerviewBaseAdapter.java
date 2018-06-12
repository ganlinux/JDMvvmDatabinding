package com.jd.ganmingtao.jdmvvmframework.mvvm.floorview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import java.util.ArrayList;

/**楼层Recyclerview的基类适配器
 *
 * @author ganmingtao
 * @date 2017/12/25
 */

public abstract class FloorRecyclerviewBaseAdapter extends RecyclerView.Adapter<FloorRecyclerviewBaseAdapter.FloorViewHolder> {
    /**
     * 楼层数据源
     */
    private ArrayList<FloorEntity> mCreateFloors = new ArrayList<>();

    /**
     * 上下文
     */
    protected Context context;

    /**构造函数
     * @param context 上下文
     * @param mCreateFloors 楼层数据源
     */
    public FloorRecyclerviewBaseAdapter(Context context, ArrayList<FloorEntity> mCreateFloors) {
        this.mCreateFloors.clear();
        this.mCreateFloors.addAll(mCreateFloors);
        this.context = context;
    }

    @Override
    public FloorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        FloorViewHolder viewHolder = null;
        BaseFloorView baseFloor= createFloor(parent, viewType);
        viewHolder = new FloorViewHolder(baseFloor);
        return viewHolder;
    }

    /**创建楼层
     * @param parent 父布局
     * @param viewType 类型
     * @return 楼层基类
     */
    public abstract BaseFloorView createFloor(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(FloorViewHolder holder, int position) {
        if(holder != null){
            if(holder.baseFloor.isUseDatabinding){
                if(holder.baseFloor instanceof BaseMvvmFloorView){
                    ((BaseMvvmFloorView)holder.baseFloor).getBinding().executePendingBindings();
                }
            }
            if(getItem(position) != null){
                holder.showData(getItem(position).mData);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mCreateFloors.size();
    }
    @Override
    public int getItemViewType(int position) {
        FloorEntity entity = getItem(position);
        return entity != null ? entity.floorType : 0;
    }
    /**
     * 获取某个item对象
     * @param position
     * @return
     */
    public FloorEntity getItem(int position) {
        return mCreateFloors != null && (position <mCreateFloors.size()) ? mCreateFloors.get(position) : null;
    }

    public class FloorViewHolder extends RecyclerView.ViewHolder{
        /**
         * 楼层基类
         */
        private BaseFloorView baseFloor = null;
        public FloorViewHolder(BaseFloorView floor) {
            super(floor.getView());
            baseFloor = floor;
        }

        /**
         * 显示数据方法
         * @param entity
         */
        private void showData(Object entity){
            if(entity == null){
                return;
            }
            if(baseFloor != null){
                baseFloor.updateViewByData(entity);
            }
        }

        /**
         * 返回当前楼层名称
         * @return
         */
        private String getFloorName(){
            if(baseFloor != null){
                return baseFloor.tag;
            }else{
                return "null Floor";
            }
        }
    }
}
