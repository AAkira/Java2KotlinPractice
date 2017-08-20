package com.example.java2kotlinpractice.lesson3

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.java2kotlinpractice.R
import java.util.Random

/**
 * if / when / for / while
 */
class Lesson3Activity : AppCompatActivity() {

    private lateinit var textView: TextView // lateinitでNon-nullで遅延評価 ref) Delegates.notNull(), lazy
    private lateinit var textView2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson3)

        textView = findViewById(R.id.textView)
        textView2 = findViewById(R.id.textView2)
        lesson3_1()
        lesson3_2()
    }

    private fun lesson3_1() {
        var result = ""
        fibonacci().take(10).forEach {
            result += it.toString() + ","
        }
        textView.text = result
    }

    private fun lesson3_2() {
        val result = when (Random().nextInt(8)) { // switch -> whenに変換可能, そのまま変数に代入可能
            0 -> "Vaporeon" // シャワーズ
            1 -> "Jolteon" // サンダース
            2 -> "Flareon" // ブースター
            3 -> "Espeon" // エーフィ
            4 -> "Umbreon" // ブラッキー
            5 -> "Leafeon" // リーフィア
            6 -> "Glaceon" // グレイシア
            else -> "Sylveon" // ニンフィア
        }
        textView2.text = "Eevee evolves into $result!"
    }

    /**
     * Kotlinっぽく書いてみる
     * infinity sequence
     * 求めたい数分 takeする
     */
    private fun fibonacci() = generateSequence(1 to 1) { it.second to it.first + it.second }.map { it.first }

    // 普通に変換
//    private fun fibonacci(n: Int): Long {
//        return if (n <= 1) {
//            n.toLong()
//        } else {
//            fibonacci(n - 1) + fibonacci(n - 2)
//        }
//    }
}


//public class Lesson3Activity extends AppCompatActivity {
//
//    private TextView textView;
//    private TextView textView2;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_lesson3);
//
//        textView = findViewById(R.id.textView);
//        textView2 = findViewById(R.id.textView2);
//        lesson3_1();
//        lesson3_2();
//    }
//
//    private void lesson3_1() {
//        final List<Long> fibonacciList = new ArrayList<>();
//
//        for (int i = 1; i <= 10; i++) {
//            fibonacciList.add(fibonacci(i));
//        }
//
//        String result = "";
//        for (Long item : fibonacciList) {
//            result += item + ",";
//        }
//        textView.setText(result);
//    }
//
//    public static long fibonacci(int n) {
//        if (n <= 1) {
//            return n;
//        } else {
//            return fibonacci(n - 1) + fibonacci(n - 2);
//        }
//    }
//
//    private void lesson3_2() {
//        final Random random = new Random();
//        int randomValue = random.nextInt(8);
//
//        String result = "Eevee"; // イーブイ
//        switch (randomValue) {
//            case 0:
//            result = "Vaporeon"; // シャワーズ
//            break;
//            case 1:
//            result = "Jolteon"; // サンダース
//            break;
//            case 2:
//            result = "Flareon"; // ブースター
//            break;
//            case 3:
//            result = "Espeon"; // エーフィ
//            break;
//            case 4:
//            result = "Umbreon"; // ブラッキー
//            break;
//            case 5:
//            result = "Leafeon"; // リーフィア
//            break;
//            case 6:
//            result = "Glaceon"; // グレイシア
//            break;
//            default:
//            result = "Sylveon"; // ニンフィア
//            break;
//        }
//        textView2.setText("Eevee evolves into " + result + "!");
//    }
//}
