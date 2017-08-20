package com.example.java2kotlinpractice.lesson5

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.java2kotlinpractice.R
import com.example.java2kotlinpractice.lesson4.Pokemon
import com.example.java2kotlinpractice.lesson4.gotcha

/**
 * Extension
 */
class Lesson5Activity : AppCompatActivity() {

    private lateinit var textView: TextView // lateinitでnon-nullに遅延評価可能 ref) Delegates.notNull(), lazy
    private lateinit var textView2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson5)

        textView = findViewById(R.id.textView)
        textView2 = findViewById(R.id.textView2)
        lesson5_1()
        lesson5_2()
    }

    private fun lesson5_1() {
        val hoOh = Pokemon("Ho-oh", 106, 130, 90, 90)
        val newPokemon = gotcha(hoOh)

        newPokemon?.let {
            // newPokemonがnon-nullじゃなければletのblock内を実行
            // lateinitでnon-null型なのでtext viewのnull checkは不要
            // 初期化されていない場合はUninitializedPropertyAccessExceptionで落ちる
            textView.text = it.name
        } ?: run {
            textView.text = hoOh.name
        }
    }

    private fun lesson5_2() {
        gotchaLegend()?.run { // runを使うとblock内にthisでアクセス可能. 動作はletと同じ letはitでのアクセス
            // 努力値をセット
            effortHp = 252
            effortAttack = 252
            effortDefence = 4
            effortSpeed = 0
            textView2.text = name
        } ?: run {
            textView2.text = "Mistake"
        }
    }
}

//public class Lesson5Activity extends AppCompatActivity {
//
//    private TextView textView;
//    private TextView textView2;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_lesson5);
//
//        textView = findViewById(R.id.textView);
//        textView2 = findViewById(R.id.textView2);
//        lesson5_1();
//        lesson5_2();
//    }
//
//    private void lesson5_1() {
//        final Pokemon hoOh = new Pokemon("Ho-oh", 106, 130, 90, 90);
//        final Pokemon newPokemon = gotcha(hoOh);
//
//        if (newPokemon != null) {
//            textView.setText(newPokemon.getName());
//        } else {
//            textView.setText(hoOh.getName());
//        }
//    }
//
//    private void lesson5_2() {
//        final Pokemon pokemon = gotchaLegend();
//
//        if(pokemon!= null) {
//            // 努力値をセット
//            pokemon.setEffortHp(252);
//            pokemon.setEffortAttack(252);
//            pokemon.setEffortDefence(4);
//            pokemon.setEffortSpeed(0);
//            textView2.setText(pokemon.getName());
//        }else {
//            textView2.setText("Mistake!");
//        }
//    }
//}
