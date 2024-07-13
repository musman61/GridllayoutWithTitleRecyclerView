package com.example.gridllayoutwithtitlerecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class YourAdapter(private val items: List<Any>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_ITEM = 0
        const val VIEW_TYPE_TITLE = 1
        const val VIEW_TYPE_LARGE_ITEM = 2
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is YourItemType -> VIEW_TYPE_ITEM
            is String -> VIEW_TYPE_TITLE
            is LargeItemType -> VIEW_TYPE_LARGE_ITEM
            else -> throw IllegalArgumentException("Invalid type of data $position")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_ITEM -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
                ItemViewHolder(view)
            }
            VIEW_TYPE_TITLE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.title_layout, parent, false)
                TitleViewHolder(view)
            }
            VIEW_TYPE_LARGE_ITEM -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.large_item_layout, parent, false)
                LargeItemViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ItemViewHolder -> holder.bind(items[position] as YourItemType)
            is TitleViewHolder -> holder.bind(items[position] as String)
            is LargeItemViewHolder -> holder.bind(items[position] as LargeItemType)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val itemImage: ImageView = view.findViewById(R.id.icon)
        private val itemTitle: TextView = view.findViewById(R.id.title)

        fun bind(item: YourItemType) {
            itemTitle.text = item.title
            itemImage.setImageResource(item.image)
        }
    }

    class TitleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val titleText: TextView = view.findViewById(R.id.title_text)

        fun bind(title: String) {
            titleText.text = title
        }
    }

    class LargeItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val itemImage: ImageView = view.findViewById(R.id.item_image)
        private val itemTitle: TextView = view.findViewById(R.id.item_title)

        fun bind(item: LargeItemType) {
            itemTitle.text = item.title
            itemImage.setImageResource(item.imageResId)
        }
    }

}