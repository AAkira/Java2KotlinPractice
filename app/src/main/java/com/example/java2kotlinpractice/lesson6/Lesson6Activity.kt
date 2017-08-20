package com.example.java2kotlinpractice.lesson6

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.example.java2kotlinpractice.R
import com.example.java2kotlinpractice.lesson4.Pokemon
import com.example.java2kotlinpractice.lesson5.gotchaLegend

/**
 * Lambda
 */
class Lesson6Activity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var textView: TextView
    private lateinit var button2: Button
    private lateinit var textView2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson6)

        button = findViewById(R.id.button)
        textView = findViewById(R.id.textView)
        button2 = findViewById(R.id.button2)
        textView2 = findViewById(R.id.textView2)
        lesson6_1()
        lesson6_2()
    }

    private fun lesson6_1() {
        button.setOnClickListener {
            gotchaLegend()?.let { pokemon ->
                // itに名前を付けないと中のlambda式と名前が衝突する
                textView.text = pokemon.heldItem?.let { "${pokemon.name} has ${it.name}" } ?: "${pokemon.name} doesn't have items."
            } ?: run {
                textView.text = "Mistake!"
            }
        }
    }

    private fun lesson6_2() {

        // UI threadを止めてるのでhandlerを使ってtext viewを更新
        // handlerはandroidのthread間通信を実現するもの
        // https://developer.android.com/reference/android/os/Handler.html
        val handler = Handler()

        button2.setOnClickListener {
            button2.isClickable = false

            // 名前を付ければ引数の順序は入れ替え可能
            val mewTwo = Pokemon("Mewtwo", level = 50, baseHp = 106, baseAttack = 110, baseDefence = 90, baseSpeed = 139)
            val mew = Pokemon("Mew", level = 50, baseHp = 100, baseAttack = 100, baseDefence = 100, baseSpeed = 100)

            Thread(Runnable {
                // runnnableで囲える
                Lesson6.battle(mewTwo, mew, object : Lesson6.EventListener { // typealias等を使えるとgood
                    override fun onAttacked(attacker: Pokemon, defender: Pokemon, damage: Int) {
                        handler.post {
                            textView2.text = "${defender.name} is attacked $damage damage from ${attacker.name}"
                        }
                    }

                    override fun onBattleEnd(winner: Pokemon, loser: Pokemon) {
                        handler.post {
                            textView2.text = "${winner.name} is win."
                            button2.isClickable = true
                        }
                    }
                })
            }).start()
        }
    }
}

//public class Lesson6Activity extends AppCompatActivity {
//
//    private Button button;
//    private TextView textView;
//    private Button button2;
//    private TextView textView2;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_lesson6);
//
//        button = findViewById(R.id.button);
//        textView = findViewById(R.id.textView);
//        button2 = findViewById(R.id.button2);
//        textView2 = findViewById(R.id.textView2);
//        lesson6_1();
//        lesson6_2();
//    }
//
//    private void lesson6_1() {
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final Pokemon pokemon = gotchaLegend();
//                if (pokemon != null) {
//                    if (pokemon.getHeldItem() != null) {
//                        textView.setText(pokemon.getName() + " has " + pokemon.getHeldItem().getName());
//                    } else {
//                        textView.setText(pokemon.getName() + " doesn't have items.");
//                    }
//                } else {
//                    textView.setText("Mistake!");
//                }
//            }
//        });
//    }
//
//    private void lesson6_2() {
//
//        // UI threadを止めてるのでhandlerを使ってtext viewを更新
//        // handlerはandroidのthread間通信を実現するもの
//        // https://developer.android.com/reference/android/os/Handler.html
//        final Handler handler = new Handler();
//
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                button2.setClickable(false);
//
//                final Pokemon mewTwo = new Pokemon("Mewtwo", 106, 110, 90, 139, 50);
//                final Pokemon mew = new Pokemon("Mew", 100, 100, 100, 100, 50);
//
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Lesson6.battle(mewTwo, mew, new Lesson6.EventListener() {
//                            @Override
//                            public void onAttacked(final Pokemon attacker, final Pokemon defender, final int damage) {
//                                handler.post(new Runnable() {
//                                    public void run() {
//                                        textView2.setText(defender.getName() + " is attacked " + damage + " damage from "
//                                                + attacker.getName());
//                                    }
//                                });
//                            }
//
//                            @Override
//                            public void onBattleEnd(final Pokemon winner, final Pokemon loser) {
//                                handler.post(new Runnable() {
//                                    public void run() {
//                                        textView2.setText(winner.getName() + " is win.");
//                                        button2.setClickable(true);
//                                    }
//                                });
//                            }
//                        });
//                    }
//                }).start();
//            }
//        });
//    }
//}