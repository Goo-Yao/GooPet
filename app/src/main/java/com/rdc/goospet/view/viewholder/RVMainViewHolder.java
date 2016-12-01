package com.rdc.goospet.view.viewholder;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rdc.goospet.R;

/**
 * Created by Goo on 2016-10-19.
 */

public class RVMainViewHolder extends RecyclerView.ViewHolder {
    public TextView tvTitle;
    public TextView tvDescription;
    public SwitchCompat swSelect;
    public ImageView ivItemPic;

    public RVMainViewHolder(View itemView) {
        super(itemView);
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title_item);
        tvDescription = (TextView) itemView.findViewById(R.id.tv_description);
        swSelect = (SwitchCompat) itemView.findViewById(R.id.sw_select);
        ivItemPic = (ImageView) itemView.findViewById(R.id.iv_item_pic);
    }
}
