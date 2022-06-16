package org.dev0.jetpackpaging

import org.dev0.jetpackpaging.db.RestaurantDatabase

class AppDatabase {
    companion object{
        lateinit var db: RestaurantDatabase
    }
}