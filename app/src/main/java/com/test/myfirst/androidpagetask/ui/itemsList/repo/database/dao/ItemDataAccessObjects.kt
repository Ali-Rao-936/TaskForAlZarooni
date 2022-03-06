package com.test.myfirst.androidpagetask.ui.itemsList.repo.database.dao

import androidx.room.*
import com.test.myfirst.androidpagetask.ui.itemsList.repo.database.entities.ItemEntity

@Dao
interface ItemDataAccessObjects {
    @Insert
    fun insertItems(items: ItemEntity)

    @Query("Select * from Items")
    fun gelAllItems(): List<ItemEntity>

    @Update
    fun updateItems(users: ItemEntity)

    @Delete
    fun deleteItems(users: ItemEntity)
}