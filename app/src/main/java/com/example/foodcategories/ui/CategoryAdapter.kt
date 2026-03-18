package com.example.foodcategories.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodcategories.R
import com.example.foodcategories.data.Categoty

class CategoryAdapter : ListAdapter<Categoty, CategoryAdapter.CategoryViewHolder>(DiffCallback()) {

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryName: TextView = itemView.findViewById(R.id.category_name)
        val categoryInfo: TextView = itemView.findViewById(R.id.category_info)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)

        fun bind(category: Categoty) {
            categoryName.text = category.strCategory
            categoryInfo.text = category.strCategoryDescription
            Glide.with(itemView.context)
                .load(category.strCategoryThumb)
                .into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_card, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DiffCallback : DiffUtil.ItemCallback<Categoty>() {
        override fun areItemsTheSame(oldItem: Categoty, newItem: Categoty) =
            oldItem.idCategory == newItem.idCategory

        override fun areContentsTheSame(oldItem: Categoty, newItem: Categoty) =
            oldItem == newItem
    }
}