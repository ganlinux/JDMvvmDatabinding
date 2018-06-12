package com.jd.ganmingtao.jdmvvmframework.mvvm.recyclerview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jd.ganmingtao.jdmvvmframework.BR;

/**带数据绑定的ViewHolder基类
 * @author ganmingtao
 */
public abstract class BindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    /**
     * ViewHolder的数据绑定对象
     */
    private final T mBinding;

    /**有数据绑定的构造函数
     * @param binding binding
     */
    public BindingViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        mBinding = (T)binding;
    }

    /**不用数据绑定的构造函数
     * @param view
     */
    public BindingViewHolder(View view) {
        super(view);
        mBinding = null;
    }

    /**获取数据绑定对象
     * @return
     */
    public T getBinding() {
        return mBinding;
    }

    /**显示数据
     * @param context
     * @param item
     * @param position
     */
    public abstract void show(Context context, Object item, int position);

    public static ViewDataBinding createViewDataBinding(Context context, ViewGroup parent, int layoutId){
        return  DataBindingUtil.inflate(LayoutInflater.from(context), layoutId, parent, false);
    }

    public void bind(){
        mBinding.setVariable(BR.item, this);
        mBinding.executePendingBindings();
    }

    /**绑定并显示数据
     * @param context
     * @param item
     * @param position
     */
    public void bindAndShow(Context context, Object item, int position){
        bind();
        show(context, item, position);
    }
}