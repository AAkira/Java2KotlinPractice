package com.example.java2kotlinpractice.lesson1;

import com.example.java2kotlinpractice.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Random;

/**
 * var, val
 * 型推論
 */
public class Lesson1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1);

        final TextView textView = findViewById(R.id.textView);
        final TextView textView2 = findViewById(R.id.textView2);

        final Random random = new Random();

        int randomValue = random.nextInt(1);
        final String text = randomValue == 0 ? "Java" : "Kotlin";
        textView.setText(text);

        randomValue = random.nextInt(1);
        final String text2 = randomValue == 0 ? "var" : "val";
        textView2.setText(text2);
    }
}