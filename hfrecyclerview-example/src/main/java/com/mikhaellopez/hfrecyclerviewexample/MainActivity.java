package com.mikhaellopez.hfrecyclerviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Init Data
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add("Example " + i);
        }

        // Add Adapter
        ExampleAdapter adapter = new ExampleAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}
