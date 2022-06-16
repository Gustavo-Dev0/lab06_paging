package org.dev0.jetpackpaging.db

import androidx.room.Database
import androidx.room.RoomDatabase
import org.dev0.jetpackpaging.model.Restaurant

@Database(
    entities = [Restaurant::class],
    version = 1,
    exportSchema = false
)
abstract class RestaurantDatabase: RoomDatabase() {
    abstract fun restaurantDao(): RestaurantDao
}