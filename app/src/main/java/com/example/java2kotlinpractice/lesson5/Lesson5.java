package com.example.java2kotlinpractice.lesson5;

import com.example.java2kotlinpractice.lesson4.Item;
import com.example.java2kotlinpractice.lesson4.Pokemon;

import java.util.Random;

public class Lesson5 {

    /**
     * 伝説のポケモンを捕まえる
     * 持ち物を持っている場合がある
     *
     * @return nullableでpokemonを返す
     */
    public static Pokemon gotchaLegend() {
        final Random random = new Random();
        int randomValue = random.nextInt(4);

        Pokemon pokemon;
        switch (randomValue) {
            case 0:
                pokemon = new Pokemon("Moltres", 90, 100, 90, 90, 50); //ファイヤー
                pokemon.setHeldItem(new Item("Fire Stone",
                        "A peculiar stone that can make certain species of Pokémon evolve. The stone has a fiery orange heart.")); //ほのおのいし
                break;
            case 1:
                pokemon = new Pokemon("Zapdos", 90, 90, 85, 100, 50); //サンダー
                pokemon.setHeldItem(new Item("Thunder Stone",
                        "A peculiar stone that can make certain species of Pokémon evolve. It has a distinct thunderbolt pattern.")); //かみなりのいし
                break;
            case 2:
                pokemon = new Pokemon("Articuno", 90, 85, 100, 85, 50); //フリーザ
                pokemon.setHeldItem(new Item("Ice Stone",
                        "A peculiar stone that can make certain species of Pokémon evolve. It has an unmistakable snowflake pattern.")); //こおりのいし
                break;
            default:
                pokemon = null;
                break;
        }
        return pokemon;
    }
}
