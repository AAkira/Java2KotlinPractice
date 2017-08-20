package com.example.java2kotlinpractice.lesson4;

import android.support.annotation.Nullable;

// Lesson5でもgotchaメソッドが使われている
// => kotlinはTop levelに関数をおける
public class Lesson4 {

    /**
     * @param partnerPokemon null if you don't have your partner pokemon.
     * @return pokemon nullable.
     */
    public static Pokemon gotcha(@Nullable Pokemon partnerPokemon) {
        if (partnerPokemon == null) {
            return new Pokemon("Pikachu", 35, 55, 40, 90);
        }

        if (partnerPokemon.getDefence() > partnerPokemon.getAttack()) {
            return new Pokemon("Bulbasaur", 45, 49, 49, 45); //フシギダネ
        } else if (partnerPokemon.getAttack() > partnerPokemon.getLevel() * 10) {
            return new Pokemon("Charmander", 39, 52, 43, 65); //ヒトカゲ
        } else if (partnerPokemon.getSpeed() > partnerPokemon.getLevel() * 3) {
            return new Pokemon("Squirtle", 44, 48, 65, 43); //ゼニガメ
        } else {
            return null;
        }
    }

    /**
     * @param number マイナスの場合は"Eevee"を返す <= Kotlin変換では引数"number"をnullableにする
     *               "number"マイナスではなくnullの場合に"Eevee"にを返す
     * @return 引数が0~7以外の場合はnullを返す
     */
    public static String evolveEevee(int number) {
        // kotlin変換では、numberがnullで"Eevee"返す
        if (number < 0) {
            return "Eevee";
        }

        switch (number) {
            case 0:
                return "Vaporeon";
            case 1:
                return "Jolteon";
            case 2:
                return "Flareon";
            case 3:
                return "Espeon";
            case 4:
                return "Umbreon";
            case 5:
                return "Leafeon";
            case 6:
                return "Glaceon";
            case 7:
                return "Sylveon";
            default:
                return null;
        }
    }
}
