package com.jd.ganmingtao.demo.bindingadapter;

import android.databinding.BindingAdapter;

import com.jd.ganmingtao.demo.recyclerview.customview.ProductNumTextView;

/**
 *ViewBindingAdapter
 * @author ganmingtao
 * @date 2017/12/25
 */

public class ViewBindingAdapter {
    /**更新商品数量方法
     * @param productNumTextView textview
     * @param text 文案
     */
    @BindingAdapter("lib_cart_productnum")
    public static void updateProductNum(ProductNumTextView productNumTextView, String text){
        productNumTextView.setProductNumText(text);
    }
}
