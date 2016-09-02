package com.example.youngkaaa.navigationbottomdemo1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by : youngkaaa on 2016/9/2.
 * Contact me : 645326280@qq.com
 */
public class MyRecycelerAdapter extends RecyclerView.Adapter<MyRecycelerAdapter.MyViewHolder> {
    private List<String> data;
    public MyRecycelerAdapter(){
        data=new ArrayList<>();
        data=getData();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleritem,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.textViewRecyclerItem);
        }
    }

    private List<String> getData(){
        List<String> dataTemp=new ArrayList<>();
        for(int i=0;i<80;i++){
            dataTemp.add("youngkaaa");
        }
        return dataTemp;
    }
}
