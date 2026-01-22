package com.example.geologger.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "location_table")
data class LocationEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val latitude: Double,
    val longitude: Double,
    val time: Long
)
