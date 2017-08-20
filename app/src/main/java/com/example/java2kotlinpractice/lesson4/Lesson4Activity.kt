package com.example.java2kotlinpractice.lesson4

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.java2kotlinpractice.R
import java.util.Random

/**
 * null
 */
class Lesson4Activity : AppCompatActivity() {

    private var textView: TextView? = null
    private var textView2: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson4)

        textView = findViewById(R.id.textView)
        textView2 = findViewById(R.id.textView2)
        lesson4_1()
        lesson4_2()
    }

    private fun lesson4_1() {
        // kotlin変換後はint型にnullも渡せる
        val pokemon = evolveEevee(Random().nextInt(8))

        textView?.text = pokemon // =textView.setText(),
        // ?を使って if(textView != null) textView.text = pokemon を表せる
    }

    private fun lesson4_2() {
        val newPokemon = gotcha(null)

        if (newPokemon != null) {
            textView2?.text = "Gotcha! ${newPokemon.name}"
        } else {
            textView2?.text = "Darn! The pokemon broke free!"
        }
    }
}

//public class Lesson4Activity extends AppCompatActivity {
//
//    private TextView textView;
//    private TextView textView2;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_lesson4);
//
//        textView = findViewById(R.id.textView);
//        textView2 = findViewById(R.id.textView2);
//        lesson4_1();
//        lesson4_2();
//    }
//
//    private void lesson4_1() {
//        final Random random = new Random();
//        int randomValue = random.nextInt(8);
//        // kotlin変換後はint型にnullも渡せる
//        String pokemon = evolveEevee(randomValue);
//
//        if (pokemon != null) {
//            textView.setText(pokemon);
//        }
//    }
//
//    private void lesson4_2() {
//        Pokemon newPokemon = gotcha(null);
//        if (newPokemon != null) {
//            textView2.setText("Gotcha! " + newPokemon.getName());
//        } else {
//            textView2.setText("Darn! The pokemon broke free!");
//        }
//    }
//}
