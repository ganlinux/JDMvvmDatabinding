package com.jd.ganmingtao.demo.recyclerview.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**商品数量textview控件
 *
 * @author ganmingtao
 * @date 2017/12/26
 */

public class ProductNumTextView extends android.support.v7.widget.AppCompatTextView{
    /**构造函数
     * @param context 上下文
     */
    public ProductNumTextView(Context context) {
        super(context);
    }

    /**
     * @param context 上下文
     * @param attrs 属性
     */
    public ProductNumTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context 上下文
     * @param attrs 属性
     * @param defStyleAttr 默认属性
     */
    public ProductNumTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**设置商品数量方法
     * @param text 文案
     */
    public void setProductNumText(String text){
        setText(text);
    }
}
