package com.mikhaellopez.hfrecyclerviewkotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.Collections.emptyList

/**
 * Copyright (C) 2018 Mikhael LOPEZ
 * Licensed under the Apache License Version 2.0
 */
abstract class HFRecyclerView<T>(private val withHeader: Boolean, private val withFooter: Boolean)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_ITEM = 1
        private const val TYPE_FOOTER = 2
    }

    var data: List<T> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    //region Get View
    protected abstract fun getItemView(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder

    protected abstract fun getHeaderView(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder?

    protected abstract fun getFooterView(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder?
    //endregion

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_ITEM -> getItemView(inflater, parent)
            TYPE_HEADER -> getHeaderView(inflater, parent) ?: throw RuntimeException("Empty view")
            TYPE_FOOTER -> getFooterView(inflater, parent) ?: throw RuntimeException("Empty view")
            else -> throw RuntimeException("there is no type that matches the type $viewType + make sure your using types correctly")
        }
    }

    override fun getItemCount(): Int {
        var itemCount = getRealItemCount()
        if (withHeader) itemCount++
        if (withFooter) itemCount++
        return itemCount
    }

    override fun getItemViewType(position: Int): Int =
            if (withHeader && isPositionHeader(position)) TYPE_HEADER
            else if (withFooter && isPositionFooter(position)) TYPE_FOOTER
            else TYPE_ITEM

    private fun isPositionHeader(position: Int): Boolean = position == 0

    private fun isPositionFooter(position: Int): Boolean = position == itemCount - 1

    protected fun getRealItemCount(): Int = data.size

    protected fun getItem(position: Int): T =
            if (withHeader) data[position - 1] else data[position]

}