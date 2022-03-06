package com.test.myfirst.androidpagetask.ui.itemsList.repo.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Items")
data class ItemEntity(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    val title: String,
    val sorting_order: Int?,
    val lock_status : Int?

)