package com.example.java2kotlinpractice.lesson1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.java2kotlinpractice.R
import java.util.Random

/**
 * var, val
 * 型推論
 */
class Lesson1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson1)

        val textView = findViewById<TextView>(R.id.textView) // finalはval
        val textView2 = findViewById<TextView>(R.id.textView2)

        val random = Random() // newが要らない
        var randomValue = random.nextInt(1) // 変更の可能性があるので var
        val text = if (randomValue == 0) "Java" else "Kotlin" // if-elseが値を返す
        textView.text = text // Java : textView.setText(text)

        randomValue = random.nextInt(1)
        val text2 = if (randomValue == 0) "var" else "val"
        textView2.text = text2
    }
}

//public class Lesson1Activity extends AppCompatActivity {
// @Override
// protected void onCreate(@Nullable Bundle savedInstanceState) {
//     super.onCreate(savedInstanceState);
//     setContentView(R.layout.activity_lesson1);
//
//     final TextView textView = findViewById(R.id.textView);
//     final TextView textView2 = findViewById(R.id.textView2);
//
//     final Random random = new Random();
//
//     int randomValue = random.nextInt(1);
//     final String text = randomValue == 0 ? "Java" : "Kotlin";
//     textView.setText(text);
//
//     randomValue = random.nextInt(1);
//     final String text2 = randomValue == 0 ? "var" : "val";
//     textView2.setText(text2);
// }
//}

