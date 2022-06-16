package org.dev0.jetpackpaging.repository

import androidx.paging.PagingSource
import org.dev0.jetpackpaging.AppDatabase.Companion.db
import org.dev0.jetpackpaging.db.RestaurantDao
import org.dev0.jetpackpaging.model.Restaurant

class RestaurantRepository(
    private val restaurantDao: RestaurantDao = db.restaurantDao()
) {
    fun restaurantPagingSource() = RestaurantPagingSource(null)
    //fun restaurantPagingSource() = restaurantDao.pagingSource()
}