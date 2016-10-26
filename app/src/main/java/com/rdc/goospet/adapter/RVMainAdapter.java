package com.rdc.goospet.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rdc.goospet.R;
import com.rdc.goospet.entity.PetInfo;
import com.rdc.goospet.view.viewholder.RVMainViewHolder;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Adapter - 主界面RecyclerView
 * Created by Goo on 2016-10-19.
 */
public class RVMainAdapter extends RecyclerView.Adapter implements View.OnClickListener {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<PetInfo> mData;

    public RVMainAdapter(Context context, ArrayList<PetInfo> data) {
        mContext = context;
        mData = data;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = mLayoutInflater.inflate(R.layout.layout_rv_item_main, parent, false);
        RVMainViewHolder holder = new RVMainViewHolder(rootView);
        rootView.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PetInfo tempInfo = mData.get(position);
        if (holder instanceof RVMainViewHolder) {
            ((RVMainViewHolder) holder).tvTitle.setText(tempInfo.getName());
            ((RVMainViewHolder) holder).tvDescription.setText(tempInfo.getDescription());
            ((RVMainViewHolder) holder).swSelect.setChecked(tempInfo.isSelected());
            holder.itemView.setBackgroundColor(Color.parseColor(tempInfo.getBgColor()));
            holder.itemView.setTag(mData.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(v, (PetInfo) v.getTag());
        }
    }

    private OnRvItemClickListener mOnItemClickListener = null;

    public static interface OnRvItemClickListener {
        void onItemClick(View view, PetInfo petInfo);
    }

    public void setOnRvItemClickListener(OnRvItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    public void swapData(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(mData, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(mData, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }
}
