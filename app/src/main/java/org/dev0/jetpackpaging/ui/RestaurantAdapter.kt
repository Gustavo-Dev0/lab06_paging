package org.dev0.jetpackpaging.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import org.dev0.jetpackpaging.R
import org.dev0.jetpackpaging.model.Restaurant

class RestaurantAdapter : PagingDataAdapter<Restaurant, RestaurantViewHolder>(DiffUtilCallBack())  {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_restaurant, parent, false)
        return RestaurantViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val item = getItem(position)
        item?.let { restaurant ->
            holder.bind(restaurant)
        }
    }

    class DiffUtilCallBack : DiffUtil.ItemCallback<Restaurant>() {
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem == newItem
        }
    }
}


