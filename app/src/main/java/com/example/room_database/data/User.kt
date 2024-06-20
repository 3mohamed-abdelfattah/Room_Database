package com.example.room_database.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users-table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val email: String
)
