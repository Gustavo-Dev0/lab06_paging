package org.dev0.jetpackpaging.ui

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.dev0.jetpackpaging.R
import org.dev0.jetpackpaging.model.Restaurant

class RestaurantViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val idText = view.findViewById(R.id.textViewId) as TextView
    private val tradenameText = view.findViewById(R.id.textViewTradename) as TextView
    private val districtText = view.findViewById(R.id.textViewDistrict) as TextView
    private val tablesText = view.findViewById(R.id.textViewTables) as TextView
    private val chairsText = view.findViewById(R.id.textViewChairs) as TextView


    fun bind(restaurant: Restaurant) {
        with(restaurant) {
            idText.text = id.toString()
            tradenameText.text = tradename
            districtText.text = district
            tablesText.text = "Mesas: "+tables.toString()
            chairsText.text = "Sillas: "+chairs.toString()

            Log.d("MainActivityRest", id.toString())
        }
    }
}