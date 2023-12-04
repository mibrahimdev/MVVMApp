package io.mibrahimdev.mvvmapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.mibrahimdev.mvvmapp.model.Product
import io.mibrahimdev.mvvmapp.R

class ProductAdapter(val onFavoriteClick: (Product) -> Unit = {}) :
    ListAdapter<Product, ProductAdapter.ItemViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewName: TextView = itemView.findViewById(R.id.name)
        private val textViewPrice: TextView = itemView.findViewById(R.id.price)
        private val imageViewFavorite: ImageView = itemView.findViewById(R.id.favorite)

        fun bind(item: Product) {
            textViewName.text = item.name
            textViewPrice.text = "${item.price}$"
            imageViewFavorite.setImageResource(
                if (item.isFavorite) {
                    R.drawable.baseline_star_filled_24
                } else {
                    R.drawable.baseline_star_border_24
                }
            )

            imageViewFavorite.setOnClickListener {
                onFavoriteClick(item)
            }

        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.productId == newItem.productId
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }
}
