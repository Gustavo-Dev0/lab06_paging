package org.dev0.jetpackpaging.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import org.dev0.jetpackpaging.model.Restaurant
import org.dev0.jetpackpaging.repository.RestaurantRepository

class RestaurantViewModel(
    private val repository: RestaurantRepository = RestaurantRepository()
) : ViewModel() {
    fun items(): Flow<PagingData<Restaurant>> {

        return Pager(
            PagingConfig(pageSize = 5, enablePlaceholders = false, prefetchDistance = 3),
            pagingSourceFactory = { repository.restaurantPagingSource() }
        ).flow.cachedIn(viewModelScope)
    }
}