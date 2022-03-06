package com.test.myfirst.androidpagetask.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.myfirst.androidpagetask.ui.itemsList.repo.MainRepository
import com.test.myfirst.androidpagetask.ui.itemsList.repo.database.entities.ItemEntity
import kotlinx.coroutines.launch

class MainViewModel(val repository: MainRepository) : ViewModel() {

    var lst = MutableLiveData<List<ItemEntity>>()
    var newlist = arrayListOf<ItemEntity>()

    fun add(blog: ItemEntity) {
        newlist.add(blog)
        lst.value = newlist
    }

    fun remove(blog: ItemEntity) {
        newlist.remove(blog)
        lst.value = newlist
    }


    private fun loadData() {
        // This is a coroutine scope with the lifecycle of the ViewModel

        viewModelScope.launch {
            // getAllItems() is a suspend function
            val itemList = repository.getAllItems()
            itemList.sortedBy {
                it.sorting_order
            }
            lst.postValue(itemList)
        }
    }
}