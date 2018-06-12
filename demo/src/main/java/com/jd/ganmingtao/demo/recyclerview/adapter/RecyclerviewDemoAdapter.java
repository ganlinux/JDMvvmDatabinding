package com.jd.ganmingtao.demo.recyclerview.adapter;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jd.ganmingtao.demo.R;
import com.jd.ganmingtao.demo.recyclerview.entity.ProductEntity;
import com.jd.ganmingtao.demo.recyclerview.viewholder.RecyclerviewDemoHeaderViewHolder;
import com.jd.ganmingtao.demo.recyclerview.viewholder.RecyclerviewDemoItemViewHolder;
import java.util.ArrayList;

/**Recyclerview示例的适配器
 *
 * @author ganmingtao
 * @date 2017/12/25
 */

public class RecyclerviewDemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    /**
     * 数据源
     */
    private ArrayList<ProductEntity> productEntityArrayList = new ArrayList<>();

    /**
     * 上下文
     */
    private Context context;

    /**
     * @param context 上下文
     * @param productEntityArrayList 数据源
     */
    public RecyclerviewDemoAdapter(Context context, ArrayList<ProductEntity> productEntityArrayList) {
        this.productEntityArrayList.clear();
        this.productEntityArrayList.addAll(productEntityArrayList);
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType){
            case 1:
                View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_header_product,parent,false);
                viewHolder = new RecyclerviewDemoHeaderViewHolder(view);
                break;
            case 2:
                ViewDataBinding recyclerviewDemoItemBinding = RecyclerviewDemoItemViewHolder.createViewDataBinding(context, parent, R.layout.recyclerview_item_product);
                viewHolder = new RecyclerviewDemoItemViewHolder(recyclerviewDemoItemBinding);
                break;
            default:
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof RecyclerviewDemoItemViewHolder){
            RecyclerviewDemoItemViewHolder recyclerviewDemoItemViewHolder = (RecyclerviewDemoItemViewHolder)holder;
            recyclerviewDemoItemViewHolder.bindAndShow(context, productEntityArrayList.get(position - 1), position);
        }else if(holder instanceof RecyclerviewDemoHeaderViewHolder){

        }
    }

    @Override
    public int getItemCount() {
        return productEntityArrayList.size() + 1;
    }
    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return 1;
        }
        return 2;
    }
}
