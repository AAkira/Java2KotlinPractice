package com.example.java2kotlinpractice.lesson3;

import com.example.java2kotlinpractice.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * if / when / for / while
 */
public class Lesson3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3);

        TextView textView = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);

        ///////////////////////////////////
        final List<Long> fibonacciList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            fibonacciList.add(fibonacci(i));
        }

        String result = "";
        for (Long item : fibonacciList) {
            result += item + ",";
        }
        textView.setText(result);

        ///////////////////////////////////
        final Random random = new Random();
        int randomValue = random.nextInt(8);

        switch (randomValue) {
            case 0:
                result = "Vaporeon"; // シャワーズ
                break;
            case 1:
                result = "Jolteon"; // サンダース
                break;
            case 2:
                result = "Flareon"; // ブースター
                break;
            case 3:
                result = "Espeon"; // エーフィ
                break;
            case 4:
                result = "Umbreon"; // ブラッキー
                break;
            case 5:
                result = "Leafeon"; // リーフィア
                break;
            case 6:
                result = "Glaceon"; // グレイシア
                break;
            default:
                result = "Sylveon"; // ニンフィア
                break;
        }
        textView2.setText("Eevee evolves into " + result + "!");
    }


    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}