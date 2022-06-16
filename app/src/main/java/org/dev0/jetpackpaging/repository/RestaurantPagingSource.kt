package org.dev0.jetpackpaging.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import org.dev0.jetpackpaging.AppDatabase.Companion.db
import org.dev0.jetpackpaging.ExampleBackendService
import org.dev0.jetpackpaging.model.Restaurant
import java.lang.Integer.max

private const val STARTING_KEY = 1


class RestaurantPagingSource(
    val backendService: ExampleBackendService?
) : PagingSource<Int, Restaurant>() {
    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, Restaurant> {
        val position = params.key ?: STARTING_KEY
        val dao = db.restaurantDao()
        val response = dao.getAll((position-1)*params.loadSize, params.loadSize)
        return LoadResult.Page(
            data = response,
            prevKey = if(position-1 > 0) position-1 else null,
            nextKey = position+1
        )
    }

    override fun getRefreshKey(state: PagingState<Int, Restaurant>): Int? {

        val anchorPosition = state.anchorPosition ?: return null
        val article = state.closestItemToPosition(anchorPosition) ?: return null
        return ensureValidKey(key = article.id!! - (state.config.pageSize / 2))
    }

    private fun ensureValidKey(key: Int?) = max(STARTING_KEY, key!!)
}