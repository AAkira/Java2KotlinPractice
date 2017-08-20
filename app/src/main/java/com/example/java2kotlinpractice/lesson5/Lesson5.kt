package com.example.java2kotlinpractice.lesson5

import com.example.java2kotlinpractice.lesson4.Item
import com.example.java2kotlinpractice.lesson4.Pokemon

import java.util.Random

/**
 * 伝説のポケモンを捕まえる
 * 持ち物を持っている場合がある
 *
 * @return nullableでpokemonを返す
 */
fun gotchaLegend() = when (Random().nextInt(4)) { // =でそのままreturn出来る. 戻り値は型推論
    0 -> Pokemon("Moltres", 90, 100, 90, 90, 50).apply {
        // applyを使ってそのまま値を代入できる
        //ファイヤー
        heldItem = Item("Fire Stone",
                "A peculiar stone that can make certain species of Pokémon evolve. The stone has a fiery orange heart.") //ほのおのいし
    }
    1 -> Pokemon("Zapdos", 90, 90, 85, 100, 50).apply {
        //サンダー
        heldItem = Item("Thunder Stone",
                "A peculiar stone that can make certain species of Pokémon evolve. It has a distinct thunderbolt pattern.") //かみなりのいし
    }
    2 -> Pokemon("Articuno", 90, 85, 100, 85, 50).apply {
        //フリーザ
        heldItem = Item("Ice Stone",
                "A peculiar stone that can make certain species of Pokémon evolve. It has an unmistakable snowflake pattern.") //こおりのいし
    }
    else -> null
}

//public static Pokemon gotchaLegend() {
//    final Random random = new Random();
//    int randomValue = random.nextInt(4);
//
//    Pokemon pokemon;
//    switch (randomValue) {
//        case 0:
//        pokemon = new Pokemon("Moltres", 90, 100, 90, 90, 50); //ファイヤー
//        pokemon.setHeldItem(new Item("Fire Stone",
//                "A peculiar stone that can make certain species of Pokémon evolve. The stone has a fiery orange heart.")); //ほのおのいし
//        break;
//        case 1:
//        pokemon = new Pokemon("Zapdos", 90, 90, 85, 100, 50); //サンダー
//        pokemon.setHeldItem(new Item("Thunder Stone",
//                "A peculiar stone that can make certain species of Pokémon evolve. It has a distinct thunderbolt pattern.")); //かみなりのいし
//        break;
//        case 2:
//        pokemon = new Pokemon("Articuno", 90, 85, 100, 85, 50); //フリーザ
//        pokemon.setHeldItem(new Item("Ice Stone",
//                "A peculiar stone that can make certain species of Pokémon evolve. It has an unmistakable snowflake pattern.")); //こおりのいし
//        break;
//        default:
//        pokemon = null;
//        break;
//    }
//    return pokemon;
//}