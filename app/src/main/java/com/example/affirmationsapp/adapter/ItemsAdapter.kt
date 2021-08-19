package com.example.affirmationsapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmationsapp.databinding.ListItemBinding
import com.example.affirmationsapp.models.Affirmation

class ItemsAdapter(private val context: Context, private var list: List<Affirmation>) :
    RecyclerView.Adapter<ItemsAdapter.ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ItemHolder(binding)
    }


    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val affirmation = list[position]
        holder.bindData(affirmation, context)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ItemHolder(var itemBinding: ListItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        @SuppressLint("UseCompatLoadingForDrawables")
        fun bindData(affirmation: Affirmation, context: Context) {
            itemBinding.affirmationString.text = context.getString(affirmation.stringResourceId)
            itemBinding.imageView.setImageResource(affirmation.imageResourceId)
        }
    }
}