package com.example.java2kotlinpractice.lesson2;

import com.example.java2kotlinpractice.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * data class
 */
public class Lesson2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2);

        TextView textView = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);

        final PokemonData pikachu = new PokemonData("Pikachu", 35);
        final PokemonData lugia = new PokemonData("Lugia", 50, 106);

        textView.setText(lugia.getName() + " attacks " + pikachu.getName());

        pikachu.setHp(0);
        textView2.setText("Pikachu HP: " + pikachu.getHp());
    }
}