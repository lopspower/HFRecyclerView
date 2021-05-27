package com.mikhaellopez.hfrecyclerviewexample.java;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mikhaellopez.hfrecyclerviewexample.R;
import com.mikhaellopez.hfrecyclerviewkotlin.HFRecyclerView;

import org.jetbrains.annotations.NotNull;

public class ExampleAdapter extends HFRecyclerView<String> {

    public ExampleAdapter() {
        // With Header & With Footer
        super(true, true);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            itemViewHolder.bind(getItem(position));
        } else if (holder instanceof HeaderViewHolder) {

        } else if (holder instanceof FooterViewHolder) {

        }
    }

    //region Override Get ViewHolder
    @NotNull
    @Override
    protected RecyclerView.ViewHolder getItemView(LayoutInflater inflater, @NotNull ViewGroup parent) {
        return new ItemViewHolder(inflater.inflate(R.layout.item_example, parent, false));
    }

    @Override
    protected RecyclerView.ViewHolder getHeaderView(LayoutInflater inflater, @NotNull ViewGroup parent) {
        return new HeaderViewHolder(inflater.inflate(R.layout.item_header, parent, false));
    }

    @Override
    protected RecyclerView.ViewHolder getFooterView(LayoutInflater inflater, @NotNull ViewGroup parent) {
        return new FooterViewHolder(inflater.inflate(R.layout.item_footer, parent, false));
    }
    //endregion

    //region ViewHolder Header and Footer
    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView text;

        ItemViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
        }

        void bind(String item) {
            text.setText(item);
        }
    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        HeaderViewHolder(View view) {
            super(view);
        }
    }

    static class FooterViewHolder extends RecyclerView.ViewHolder {
        FooterViewHolder(View view) {
            super(view);
        }
    }
    //endregion

}
