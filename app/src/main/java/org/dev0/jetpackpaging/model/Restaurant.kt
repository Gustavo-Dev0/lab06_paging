package org.dev0.jetpackpaging.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurants")
data class Restaurant(
    @PrimaryKey val id: Int? = null,
    val tradename: String? = null,
    val ruc: String? = null,
    val address: String? = null,
    val district: String? = null,
    val tables: Int? = null,
    val chairs: Int? = null
)
