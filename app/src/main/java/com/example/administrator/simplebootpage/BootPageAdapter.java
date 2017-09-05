package com.example.administrator.simplebootpage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import java.util.List;

/**
 *  简单实现。。。。
 * Created by Administrator on 2017/9/4.
 */

public class BootPageAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<Integer> layoutList;

    public BootPageAdapter(Context context, List<Integer> layoutList) {
        this.context = context;
        this.layoutList = layoutList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FlyHolder(LayoutInflater.from(context).inflate(layoutList.get(viewType), parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return layoutList.size();
    }
}
