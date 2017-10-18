package com.bawei.mvp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.mvp.JsonBeans.GameBean;
import com.bawei.mvp.R;
import com.bawei.mvp.network.OkhttpUtils;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.MyViewHolder> implements View.OnClickListener {
    private GameBean bean;
    private Context context;
    private View view;

    public MyRecycleViewAdapter(GameBean bean, Context context) {
        this.bean = bean;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = View.inflate(context, R.layout.item, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(this);
        return myViewHolder;
    }

    @Override
    public void onClick(View view) {
        if(mMyItemclickListener!=null){
//            mMyItemclickListener.itemclick(view, (Integer) view.getTag());
            mMyItemclickListener.itemclick(view, (Integer) view.getTag());
        }
    }

    public interface MyItemclickListener{
        void itemclick(View view,int position);
    }
    public MyItemclickListener mMyItemclickListener;

    public void setmMyItemclickListener(MyItemclickListener mMyItemclickListener) {
        this.mMyItemclickListener = mMyItemclickListener;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_title.setText(bean.apk.get(position).categoryName);
        OkhttpUtils.displayImage(holder.iv_icon,bean.apk.get(position).iconUrl,R.mipmap.ic_launcher);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return bean.apk.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView iv_icon;
        private final TextView tv_title;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_icon = itemView.findViewById(R.id.iv_icon);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }
}