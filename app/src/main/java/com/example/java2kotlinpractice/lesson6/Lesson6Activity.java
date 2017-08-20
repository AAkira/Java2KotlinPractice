package com.example.java2kotlinpractice.lesson6;

import com.example.java2kotlinpractice.R;
import com.example.java2kotlinpractice.lesson4.Pokemon;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.java2kotlinpractice.lesson5.Lesson5.gotchaLegend;

/**
 * Lambda
 */
public class Lesson6Activity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private Button button2;
    private TextView textView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson6);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        button2 = findViewById(R.id.button2);
        textView2 = findViewById(R.id.textView2);
        lesson6_1();
        lesson6_2();
    }

    private void lesson6_1() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Pokemon pokemon = gotchaLegend();
                if (pokemon != null) {
                    if (pokemon.getHeldItem() != null) {
                        textView.setText(pokemon.getName() + " has " + pokemon.getHeldItem().getName());
                    } else {
                        textView.setText(pokemon.getName() + " doesn't have items.");
                    }
                } else {
                    textView.setText("Mistake!");
                }
            }
        });
    }

    private void lesson6_2() {

        // UI threadを止めてるのでhandlerを使ってtext viewを更新
        // handlerはandroidのthread間通信を実現するもの
        // https://developer.android.com/reference/android/os/Handler.html
        final Handler handler = new Handler();

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                button2.setClickable(false);

                final Pokemon mewTwo = new Pokemon("Mewtwo", 50, 106, 110, 90, 139);
                final Pokemon mew = new Pokemon("Mew", 50, 100, 100, 100, 100);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Lesson6.battle(mewTwo, mew, new Lesson6.EventListener() {
                            @Override
                            public void onAttacked(final Pokemon attacker, final Pokemon defender, final int damage) {
                                handler.post(new Runnable() {
                                    public void run() {
                                        textView2.setText(defender.getName() + " is attacked " + damage + " damage from "
                                                + attacker.getName());
                                    }
                                });
                            }

                            @Override
                            public void onBattleEnd(final Pokemon winner, final Pokemon loser) {
                                handler.post(new Runnable() {
                                    public void run() {
                                        textView2.setText(winner.getName() + " is win.");
                                        button2.setClickable(true);
                                    }
                                });
                            }
                        });
                    }
                }).start();
            }
        });
    }
}