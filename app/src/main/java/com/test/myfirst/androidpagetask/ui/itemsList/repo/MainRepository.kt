package com.test.myfirst.androidpagetask.ui.itemsList.repo

import android.content.Context
import android.os.AsyncTask
import com.test.myfirst.androidpagetask.ui.itemsList.repo.database.AppDatabase
import com.test.myfirst.androidpagetask.ui.itemsList.repo.database.dao.ItemDataAccessObjects
import com.test.myfirst.androidpagetask.ui.itemsList.repo.database.entities.ItemEntity

class MainRepository(context: Context) {

    var db: ItemDataAccessObjects = AppDatabase.getInstance(context)?.itemsDao()!!

    fun getAllItems(): List<ItemEntity> {
        return db.gelAllItems()
    }

    fun insertItems(Items: ItemEntity) {
        insertAsyncTask(db).execute(Items)
    }

    fun updateItems(Items: ItemEntity) {
        db.updateItems(Items)
    }

    fun deleteItems(Items: ItemEntity) {
        db.deleteItems(Items)
    }

    private class insertAsyncTask internal constructor(private val itemsDao: ItemDataAccessObjects) :
        AsyncTask<ItemEntity, Void, Void>() {

        override fun doInBackground(vararg params: ItemEntity): Void? {
            itemsDao.insertItems(params[0])
            return null
        }
    }
}