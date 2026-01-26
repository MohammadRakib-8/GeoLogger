package com.example.geologger

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.geologger.data.db.LocationEntity
import java.text.SimpleDateFormat
import java.util.*

class LocationAdapter : RecyclerView.Adapter<LocationAdapter.ViewHolder>() {

    private var list = listOf<LocationEntity>()

    fun setLocations(locations: List<LocationEntity>) {
        list = locations
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvLocation: TextView = view.findViewById(R.id.coordinates_text_view)
        val tvTime: TextView = view.findViewById(R.id.timestamp_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_location, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.tvLocation.text = "Lat: ${item.latitude}, Lon: ${item.longitude}"


        val sdf = SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault())
        holder.tvTime.text = sdf.format(Date(item.time))
    }
}
