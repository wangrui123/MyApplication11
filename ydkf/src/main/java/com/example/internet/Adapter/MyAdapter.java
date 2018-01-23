package com.example.internet.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.internet.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author: wangrui
 * date : 2017/8/8
 * description : recyclerView用法
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<String> mData;
    private onRecyclerViewItemClick mOnRvItemClick;
    private Context mContext;

//    private List<Integer> mHeights;

    public void setOnItemClickLitener(onRecyclerViewItemClick mOnItemClickLitener) {
        this.mOnRvItemClick = mOnItemClickLitener;
    }

    public MyAdapter(ArrayList<String> data, Context mContext) {
        this.mData = data;
        this.mContext = mContext;
//        mHeights = new ArrayList<Integer>();
//
//        for (int i = 0; i < mData.size(); i++)
//        {
//            mHeights.add( (int) (100 + Math.random() * 300));
//        }
    }

    public void updateData(ArrayList<String> data) {
        this.mData = data;
        notifyDataSetChanged();
    }


    public void addNewItem(int position) {
        if (mData == null) {
            mData = new ArrayList<>();
        }
        mData.add(position, "new Item");
        notifyItemInserted(position);
    }

    public void deleteItem(int position) {
        if (mData == null || mData.isEmpty()) {
            return;
        }
        mData.remove(position);
        notifyItemRemoved(position);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.view_rv_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        ViewGroup.LayoutParams lp = holder.mTv.getLayoutParams();
//        lp.height = mHeights.get(position);
//        holder.mTv.setLayoutParams(lp);

        // 绑定数据
        holder.mTv.setText(mData.get(position));

        if (mOnRvItemClick != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnRvItemClick.onItemClick(holder.itemView, pos);
//                    addNewItem(pos);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnRvItemClick.onLongItemClick(holder.itemView, pos);
//                    deleteItem(pos);
                    return false;
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_tv)
        TextView mTv;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
//            int width = ((Activity) ivImage.getContext()).getWindowManager().getDefaultDisplay().getWidth();
//            ViewGroup.LayoutParams params = mTv.getLayoutParams();
//            //设置图片的相对于屏幕的宽高比
////            params.width = width / 3;
//            params.height = (int) (200 + Math.random() * 400);
//            mTv.setLayoutParams(params);
        }
    }

    /**
     * item点击接口
     */
    public interface onRecyclerViewItemClick {

        void onItemClick(View v, int position);

        void onLongItemClick(View v, int position);

    }
}
