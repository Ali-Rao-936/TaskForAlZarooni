package com.test.myfirst.androidpagetask.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.test.myfirst.androidpagetask.R
import com.test.myfirst.androidpagetask.ui.itemsList.repo.database.entities.ItemEntity
import com.test.myfirst.androidpagetask.viewmodel.MainViewModel

class ItemAdapter(val viewModel: MainViewModel, val arrayList: ArrayList<ItemEntity>, val context: Context): RecyclerView.Adapter<ItemAdapter.NotesViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ItemViewHolder {
        var root = LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout,parent,false)
        return ItemViewHolder(root)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(arrayList.get(position))
    }

    override fun getItemCount(): Int {
        if(arrayList.size==0){
            Toast.makeText(context,"List is empty", Toast.LENGTH_LONG).show()
        }else{

        }
        return arrayList.size
    }


    inner  class ItemViewHolder(private val binding: View) : RecyclerView.ViewHolder(binding) {
        fun bind(blog: ItemEntity){
            binding.text = blog.title
            binding.rootView.setOnClickListener{


            }
            binding.delete.setOnClickListener {


                //viewModel.remove(blog)

                //notifyItemRemoved(arrayList.indexOf(blog))
            }
        }

    }

}