package com.jd.ganmingtao.jdmvvmframework.mvvm.floorview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.jd.ganmingtao.jdmvvmframework.BR;

/**有数据绑定功能的楼层基类
 *
 * @author ganmingtao
 * @date 2017/4/10
 */

public abstract class BaseMvvmFloorView<B extends ViewDataBinding> extends BaseFloorView{
    /**
     * Tag
     */
    protected String TAG = "BaseMvvmFloorView";
    /**
     * 楼层数据绑定对象
     */
    private B binding;

    /**
     * 构造函数，务必继承实现
     */
    public BaseMvvmFloorView(ViewGroup parent, Context context){
        super(parent, context, true);
        if(mRootView == null && mLayoutId != 0){
            setBinding(DataBindingUtil.<B>inflate(getLayoutInflater(mContext), mLayoutId, parent, false));
            mRootView = (ViewGroup) binding.getRoot();
            binding.setVariable(BR.floor, this);
            //                binding.executePendingBindings();
//                        mRootView = (ViewGroup) DataBindingUtil.inflate(mContext, mLayoutId, null);
        }
        mIsInit = true;
    }

    /**设置数据绑定对象
     * @param binding binding
     */
    public void setBinding(@NonNull B binding) {
        this.binding = binding;
    }

    /**获取数据绑定对象
     * @return binding
     */
    public B getBinding() {
        if (binding == null) {
            throw new NullPointerException("You should setBinding first!");
        }
        return binding;
    }
}
