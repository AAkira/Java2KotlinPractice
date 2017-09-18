package com.example.java2kotlinpractice.lesson3

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.java2kotlinpractice.R
import java.util.Random

class Lesson3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson3)

        val textView = findViewById<TextView>(R.id.textView)
        val textView2 = findViewById<TextView>(R.id.textView2)

        ///////////////////////////////////

        // 普通にやった時
//        // rangeが使える
//        val fibonacciList = (1..10).map { fibonacci(it) }
//
//        // forEach文等が用意されている(変数名前はit)
//        var result = ""
//        for (item in fibonacciList) {
//            result += item.toString() + ","
//        }
//        textView.text = result

        // generate使ったパターン
        var result1 = ""
        fibonacci().take(10).forEach {
            result1 += it.toString() + ","
        }
        textView.text = result1

        ///////////////////////////////////
        val result2 = when (Random().nextInt(8)) { // switch -> whenに変換可能, そのまま変数に代入可能
            0 -> "Vaporeon" // シャワーズ
            1 -> "Jolteon" // サンダース
            2 -> "Flareon" // ブースター
            3 -> "Espeon" // エーフィ
            4 -> "Umbreon" // ブラッキー
            5 -> "Leafeon" // リーフィア
            6 -> "Glaceon" // グレイシア
            else -> "Sylveon" // ニンフィア
        }
        textView2.text = "Eevee evolves into $result2!"
    }

//    /**
//     * staticにしたが他クラスからは使用しないのでprivate関数で
//     * 普通に変換
//     */
//    private fun fibonacci(n: Int): Long {
//        return if (n <= 1) {
//            n.toLong()
//        } else {
//            fibonacci(n - 1) + fibonacci(n - 2)
//        }
//    }

    /**
     * Kotlinっぽく書いてみる
     * infinity sequence
     * 求めたい数分 takeする
     */
    private fun fibonacci() = generateSequence(1 to 1) { it.second to it.first + it.second }.map { it.first }
}

//public class Lesson3New extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_lesson3);
//
//        TextView textView = findViewById(R.id.textView);
//        TextView textView2 = findViewById(R.id.textView2);
//
//        ///////////////////////////////////
//        final List<Long> fibonacciList = new ArrayList<>();
//
//        for (int i = 1; i <= 10; i++) {
//            fibonacciList.add(fibonacci(i));
//        }
//
//        // forEach文等が用意されている
//        String result = "";
//        for (Long item : fibonacciList) {
//            result += item + ",";
//        }
//        textView.setText(result);
//
//        ///////////////////////////////////
//        final Random random = new Random();
//        int randomValue = random.nextInt(8);
//
//        // switchはwhenを使って置き換えてみましょう
//        switch (randomValue) {
//            case 0:
//                result = "Vaporeon"; // シャワーズ
//                break;
//            case 1:
//                result = "Jolteon"; // サンダース
//                break;
//            case 2:
//                result = "Flareon"; // ブースター
//                break;
//            case 3:
//                result = "Espeon"; // エーフィ
//                break;
//            case 4:
//                result = "Umbreon"; // ブラッキー
//                break;
//            case 5:
//                result = "Leafeon"; // リーフィア
//                break;
//            case 6:
//                result = "Glaceon"; // グレイシア
//                break;
//            default:
//                result = "Sylveon"; // ニンフィア
//                break;
//        }
//        textView2.setText("Eevee evolves into " + result + "!");
//    }
//
//    /**
//     * Extra
//     * 余裕がある人はgenerateSequenceを使って書いてみるとKotlinっぽく書ける (難易度高い)
//     */
//    private static long fibonacci(int n) {
//        if (n <= 1) {
//            return n;
//        } else {
//            return fibonacci(n - 1) + fibonacci(n - 2);
//        }
//    }
//}