package com.example.java2kotlinpractice.lesson2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.java2kotlinpractice.R

/**
 * data class
 */
class Lesson2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson2)

        val textView = findViewById<TextView>(R.id.textView)
        val textView2 = findViewById<TextView>(R.id.textView2)

        val pikachu = PokemonData("Pikachu", hp = 35) // 名前付き引数
        val lugia = PokemonData("Lugia", 50, 106)

        textView.text = "${lugia.name} attacks ${pikachu.name}" // ${}で変数にアクセス可能

        pikachu.hp = 0 // Javaだとpikachu.setHp(0)
        textView2.text = "Pikachu HP: ${pikachu.hp}"
    }
}

//public class Lesson2Activity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_lesson2);
//
//        TextView textView = findViewById(R.id.textView);
//        TextView textView2 = findViewById(R.id.textView2);
//
//        final PokemonData pikachu = new PokemonData("Pikachu", 35);
//        final PokemonData lugia = new PokemonData("Lugia", 50, 106);
//
//        textView.setText(lugia.getName() + " attacks " + pikachu.getName());
//
//        pikachu.setHp(0);
//        textView2.setText("Pikachu HP: " + pikachu.getHp());
//    }
//}