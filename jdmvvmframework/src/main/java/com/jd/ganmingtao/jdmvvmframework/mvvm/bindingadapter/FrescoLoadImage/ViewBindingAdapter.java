package com.jd.ganmingtao.jdmvvmframework.mvvm.bindingadapter.FrescoLoadImage;

import android.databinding.BindingAdapter;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 *ViewBindingAdapter
 * @author ganmingtao
 * @date 2017/12/28
 */

public class ViewBindingAdapter {
    /**加载图片方法
     * @param image 图片控件
     * @param url 地址
     */
    @BindingAdapter({"fresco_load_image"})
    public static void loadImage(SimpleDraweeView image, String url){
        image.setImageURI(url);
    }
}
