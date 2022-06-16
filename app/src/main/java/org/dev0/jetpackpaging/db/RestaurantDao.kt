package org.dev0.jetpackpaging.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.dev0.jetpackpaging.model.Restaurant

@Dao
interface RestaurantDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<Restaurant>)

    @Query("SELECT * FROM restaurants")
    fun pagingSource(): PagingSource<Int, Restaurant>

    @Query("SELECT * FROM restaurants ORDER BY restaurants.id LIMIT :loadSize OFFSET :startPosition")
    suspend fun getAll(startPosition: Int, loadSize: Int): List<Restaurant>

    @Query("DELETE FROM restaurants")
    suspend fun clearAll()
}