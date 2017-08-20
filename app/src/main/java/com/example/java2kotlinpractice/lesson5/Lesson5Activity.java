package com.example.java2kotlinpractice.lesson5;

import com.example.java2kotlinpractice.R;
import com.example.java2kotlinpractice.lesson4.Pokemon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static com.example.java2kotlinpractice.lesson4.Lesson4.gotcha;
import static com.example.java2kotlinpractice.lesson5.Lesson5.gotchaLegend;

/**
 * Extension
 */
public class Lesson5Activity extends AppCompatActivity {

    private TextView textView;
    private TextView textView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson5);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        lesson5_1();
        lesson5_2();
    }

    private void lesson5_1() {
        final Pokemon hoOh = new Pokemon("Ho-oh", 106, 130, 90, 90);
        final Pokemon newPokemon = gotcha(hoOh);

        if (newPokemon != null) {
            textView.setText(newPokemon.getName());
        } else {
            textView.setText(hoOh.getName());
        }
    }

    private void lesson5_2() {
        final Pokemon pokemon = gotchaLegend();

        if(pokemon!= null) {
            // 努力値をセット
            pokemon.setEffortHp(252);
            pokemon.setEffortAttack(252);
            pokemon.setEffortDefence(4);
            pokemon.setEffortSpeed(0);
            textView2.setText(pokemon.getName());
        }else {
            textView2.setText("Mistake!");
        }
    }
}