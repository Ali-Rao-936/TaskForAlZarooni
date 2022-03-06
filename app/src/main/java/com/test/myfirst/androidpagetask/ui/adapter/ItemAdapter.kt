package com.test.myfirst.androidpagetask.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.test.myfirst.androidpagetask.R
import com.test.myfirst.androidpagetask.ui.itemsList.repo.database.entities.ItemEntity


class ItemAdapter(
    val arrayList: ArrayList<ItemEntity>,
    val context: Context, val clickCallBacks: ClickCallBacks
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ItemViewHolder {
        var root =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout, parent, false)
        return ItemViewHolder(root)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(arrayList.get(position))
    }

    override fun getItemCount(): Int {
        if (arrayList.size == 0) {
            Toast.makeText(context, "List is empty", Toast.LENGTH_LONG).show()
        } else {

        }
        return arrayList.size
    }


    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ItemEntity) {
            val title: AppCompatTextView? = itemView.tv_item_title
            val lockStatus: AppCompatImageView = itemView.iv_item_lock_status
            title?.setText(item.title)
            if (item.lock_status == 1) {
                lockStatus.setBackgroundColor(R.drawable.ic_baseline_lock_open_24)
            } else {
                lockStatus.setBackgroundColor(R.drawable.ic_baseline_lock_24)
            }
            itemView.rootView.setOnClickListener {
                //TODO Implement OnClick Here
                clickCallBacks.onItemClicked(item)

            }
        }

    }


}