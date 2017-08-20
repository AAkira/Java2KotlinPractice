package com.example.java2kotlinpractice;

import com.example.java2kotlinpractice.lesson1.Lesson1Activity;
import com.example.java2kotlinpractice.lesson2.Lesson2Activity;
import com.example.java2kotlinpractice.lesson3.Lesson3Activity;
import com.example.java2kotlinpractice.lesson4.Lesson4Activity;
import com.example.java2kotlinpractice.lesson5.Lesson5Activity;
import com.example.java2kotlinpractice.lesson6.Lesson6Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<String> list = new ArrayList<>();
        list.add("Lesson1 : val, var");
        list.add("Lesson2 : data class");
        list.add("Lesson3 : for, when");
        list.add("Lesson4 : null");
        list.add("Lesson5 : extension");
        list.add("Lesson6 : lambda");

        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(new RecyclerAdapter(this, list, new RecyclerListener() {
            @Override
            public void onRecyclerClicked(View view, int position) {

                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, Lesson1Activity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, Lesson2Activity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, Lesson3Activity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, Lesson4Activity.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this, Lesson5Activity.class));
                        break;
                    case 5:
                        startActivity(new Intent(MainActivity.this, Lesson6Activity.class));
                        break;
                }
            }
        }));
    }
}