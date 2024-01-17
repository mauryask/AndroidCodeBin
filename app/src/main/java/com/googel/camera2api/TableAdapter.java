package com.googel.camera2api;

import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.MyViewHolder>
{
    private List<TableData> dataList;

    public TableAdapter(List<TableData> dataList)
    {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.table_data_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        Log.i("LIST_SIZE", dataList.size()+"");
        TableData item = dataList.get(position);
        holder.cell1.setText(item.getSerialNo());
        holder.cell2.setText(item.getFileName());
        holder.cell3.setText(item.getFileSize());

        if(position == 0)
        {
            holder.cell1.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            holder.cell2.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            holder.cell3.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        }
    }

    @Override
    public int getItemCount()
    {
        return dataList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView cell1, cell2, cell3;
        MyViewHolder(View view)
        {
            super(view);
            cell1 = view.findViewById(R.id.cell1);
            cell2 = view.findViewById(R.id.cell2);
            cell3 = view.findViewById(R.id.cell3);
        }
    }
}
