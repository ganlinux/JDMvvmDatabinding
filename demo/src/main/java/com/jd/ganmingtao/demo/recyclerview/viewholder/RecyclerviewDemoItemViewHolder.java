package com.jd.ganmingtao.demo.recyclerview.viewholder;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import com.jd.ganmingtao.demo.RecyclerviewDemoItemBinding;
import com.jd.ganmingtao.demo.recyclerview.entity.ProductEntity;
import com.jd.ganmingtao.jdmvvmframework.mvvm.recyclerview.BindingViewHolder;

/**RecyclerviewDemo行ViewHolder
 *
 * @author ganmingtao
 * @date 2017/12/22
 */

public class RecyclerviewDemoItemViewHolder extends BindingViewHolder<RecyclerviewDemoItemBinding> {
    /**
     * 价格
     */
    public ObservableField<String> productPriceString = new ObservableField<>();
    /**
     * 大图
     */
    public ObservableField<String> productImageUrlString = new ObservableField<>();
    /**
     * 名称
     */
    public ObservableField<String> productNameString = new ObservableField<>();
    /**
     * 数量
     */
    public ObservableField<String> productNumString = new ObservableField<>();
    /**
     * 数量
     */
    public ObservableField<String> productSizeString = new ObservableField<>();
    /**
     * 颜色
     */
    public ObservableField<String> productColorString = new ObservableField<>();

    /**构造函数
     * @param binding 绑定
     */
    public RecyclerviewDemoItemViewHolder(ViewDataBinding binding) {
        super(binding);
    }

    @Override
    public void show(Context context, Object item, int position) {
        if(item != null &&  item instanceof ProductEntity){
            ProductEntity productEntity = (ProductEntity)item;
            productPriceString.set(productEntity.price);
            productNameString.set(productEntity.name);
            productImageUrlString.set(productEntity.imageUrl);
            productNumString.set(productEntity.num);
            productColorString.set("银色");
            productSizeString.set("大吸力");
        }

    }
}
