package com.googel.camera2api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.TableViewHolder>
{
    Context mContext;
    List<TableData> mList;

    TableAdapter(Context mContext, List<TableData> mList)
    {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public TableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.table_rows, parent, false);
        return new TableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TableViewHolder holder, int position)
    {
        TableData data = mList.get(position);
        holder.cell1.setText(String.valueOf(data.getItemIndex()));
        holder.cell2.setText(data.getFileName());
        holder.cell3.setText(data.getFileSize());

        holder.removeButton.setOnClickListener(view -> {
                int adapterPosition = holder.getAdapterPosition();

                if(adapterPosition != RecyclerView.NO_POSITION)
                {
                    mList.remove(adapterPosition);
                    notifyItemRemoved(adapterPosition);
                    updateIndices();
                }
        });
    }

    private void updateIndices()
    {
        for(int i=0; i<mList.size(); i++)
        {
            mList.get(i).setItemIndex(i + 1);
            notifyItemChanged(i);
        }
    }

    @Override
    public int getItemCount()
    {
        return mList.size();
    }

    public class TableViewHolder extends RecyclerView.ViewHolder
    {
        TextView cell1, cell2, cell3;
        ImageView removeButton;
        public TableViewHolder(@NonNull View view)
        {
            super(view);
            cell1 = view.findViewById(R.id.cell1);
            cell2 = view.findViewById(R.id.cell2);
            cell3 = view.findViewById(R.id.cell3);
            removeButton = view.findViewById(R.id.removeButton);
        }
    }
}
