package com.mikhaellopez.hfrecyclerviewexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Init Data
        val list = ArrayList<String>()
        for (i in 1..10) {
            list.add("Example $i")
        }

        // Add Adapter
        val adapter = ExampleAdapter()
        adapter.data = list
        findViewById<RecyclerView>(R.id.recyclerview).adapter = adapter
    }

}