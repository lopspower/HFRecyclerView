package com.mikhaellopez.hfrecyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mikhaellopez.hfrecyclerview.HFRecyclerView

class ExampleAdapter : HFRecyclerView<String>(true, true) { // With Header & With Footer

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder.ItemViewHolder -> holder.bind(getItem(position))
            is ViewHolder.HeaderViewHolder -> {
            }
            is ViewHolder.FooterViewHolder -> {
            }
        }
    }

    //region Override Get ViewHolder
    override fun getItemView(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder =
        ViewHolder.ItemViewHolder(inflater.inflate(R.layout.item_example, parent, false))

    override fun getHeaderView(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): RecyclerView.ViewHolder =
        ViewHolder.HeaderViewHolder(inflater.inflate(R.layout.item_header, parent, false))

    override fun getFooterView(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): RecyclerView.ViewHolder =
        ViewHolder.FooterViewHolder(inflater.inflate(R.layout.item_footer, parent, false))
    //endregion

    //region ViewHolder Header and Footer
    sealed class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        class ItemViewHolder(view: View) : ViewHolder(view) {

            fun bind(item: String) {
                itemView.run {
                    findViewById<TextView>(R.id.text).text = item
                }
            }
        }

        class HeaderViewHolder(view: View) : ViewHolder(view)

        class FooterViewHolder(view: View) : ViewHolder(view)

    }
    //endregion

}
