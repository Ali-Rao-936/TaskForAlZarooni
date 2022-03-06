package com.test.myfirst.androidpagetask.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.myfirst.androidpagetask.R
import com.test.myfirst.androidpagetask.ui.itemsList.repo.database.entities.ItemEntity
import com.test.myfirst.androidpagetask.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.rvItems)
        recyclerView.layoutManager = LinearLayoutManager(this)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        getDummyData()
    }

    private fun getDummyData() {
        for (i in 0..5) {
            if(i==0)
            {
                //TODO this case to make sure 0 index is always open lock
                mainViewModel.add(ItemEntity(i, "Item{$i}", i, 0));
            }
            else
            {
                mainViewModel.add(ItemEntity(i, "Item{$i}", i, 1));
            }

        }

    }

    override fun onItemClicked(itemEntity: ItemEntity) {
        val myIntent = Intent(this, SecondActivity::class.java)
        myIntent.putExtra("id", itemEntity.id)
        this.startActivity(myIntent)

    }
}