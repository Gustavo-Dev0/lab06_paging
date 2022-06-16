package org.dev0.jetpackpaging

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.paging.map
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.dev0.jetpackpaging.db.RestaurantDatabase
import org.dev0.jetpackpaging.model.Restaurant
import org.dev0.jetpackpaging.ui.RestaurantAdapter
import org.dev0.jetpackpaging.ui.RestaurantViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppDatabase.db = Room.databaseBuilder(applicationContext, RestaurantDatabase::class.java, "restaurants.db")
            .createFromAsset("Restaurants_DB.db")
            .build()

        val viewModel by viewModels<RestaurantViewModel>()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val pagingAdapter = RestaurantAdapter()

        recyclerView.adapter = pagingAdapter
        recyclerView.apply {
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        }
        lifecycleScope.launch {
            viewModel.items().collectLatest { pageData ->
                pagingAdapter.submitData(pageData)
            }
        }
    }

}