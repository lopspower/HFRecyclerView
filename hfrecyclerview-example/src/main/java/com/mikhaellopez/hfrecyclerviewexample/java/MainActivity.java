package com.mikhaellopez.hfrecyclerviewexample.java;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.mikhaellopez.hfrecyclerviewexample.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        // Init Data
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add("Example " + i);
        }

        // Add Adapter
        ExampleAdapter adapter = new ExampleAdapter();
        adapter.setData(list);
        recyclerView.setAdapter(adapter);
    }
}
