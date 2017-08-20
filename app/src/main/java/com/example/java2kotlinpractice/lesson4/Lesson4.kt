package com.example.java2kotlinpractice.lesson4

/**
 * @param partnerPokemon null if you don't have your partner pokemon.
 * @return pokemon nullable.
 */
fun gotcha(partnerPokemon: Pokemon?): Pokemon? {
    partnerPokemon ?: return Pokemon("Pikachu", 35, 55, 40, 90) // 早期returnでsmart cast, 以降でpartnerPokemonがnon-nullになる

    return if (partnerPokemon.defence > partnerPokemon.attack) {
        Pokemon("Bulbasaur", 45, 49, 49, 45) //フシギダネ
    } else if (partnerPokemon.attack > partnerPokemon.level * 10) {
        Pokemon("Charmander", 39, 52, 43, 65) //ヒトカゲ
    } else if (partnerPokemon.speed > partnerPokemon.level * 3) {
        Pokemon("Squirtle", 44, 48, 65, 43) //ゼニガメ
    } else {
        null
    }
}

// そのままif-elseでも良い
fun gotcha2(partnerPokemon: Pokemon?): Pokemon? =
        if (partnerPokemon == null) {
            Pokemon("Pikachu", 35, 55, 40, 90)
        } else if (partnerPokemon.defence > partnerPokemon.attack) {
            Pokemon("Bulbasaur", 45, 49, 49, 45) //フシギダネ
        } else if (partnerPokemon.attack > partnerPokemon.level * 10) {
            Pokemon("Charmander", 39, 52, 43, 65) //ヒトカゲ
        } else if (partnerPokemon.speed > partnerPokemon.level * 3) {
            Pokemon("Squirtle", 44, 48, 65, 43) //ゼニガメ
        } else {
            null
        }

// whenでも書ける
fun gotcha3(partnerPokemon: Pokemon?): Pokemon? = when {
    partnerPokemon == null -> Pokemon("Pikachu", 35, 55, 40, 90)
    partnerPokemon.defence > partnerPokemon.attack -> Pokemon("Bulbasaur", 45, 49, 49, 45)
    partnerPokemon.attack > partnerPokemon.level * 10 -> Pokemon("Charmander", 39, 52, 43, 65)
    partnerPokemon.speed > partnerPokemon.level * 3 -> Pokemon("Squirtle", 44, 48, 65, 43)
    else -> null
}

/**
 * @param number マイナスの場合は"Eevee"を返す <= Kotlin変換では引数"number"をnullableにする
 * "number"マイナスではなくnullの場合に"Eevee"にを返す
 * @return 引数が0~7以外の場合はnullを返す
 */
fun evolveEevee(number: Int?): String? { // int型にもnullは渡せる
    // kotlin変換では、numberがnullで"Eevee"返す
    number ?: return "Eevee"

    when (number) {
        0 -> return "Vaporeon"
        1 -> return "Jolteon"
        2 -> return "Flareon"
        3 -> return "Espeon"
        4 -> return "Umbreon"
        5 -> return "Leafeon"
        6 -> return "Glaceon"
        7 -> return "Sylveon"
        else -> return null
    }
}

//public class Lesson4 {
//
//    /**
//     * @param partnerPokemon null if you don't have your partner pokemon.
//     * @return pokemon nullable.
//     */
//    public static Pokemon gotcha(@Nullable Pokemon partnerPokemon) {
//        if (partnerPokemon == null) {
//            return new Pokemon("Pikachu", 35, 55, 40, 90);
//        }
//
//        if (partnerPokemon.getDefence() > partnerPokemon.getAttack()) {
//            return new Pokemon("Bulbasaur", 45, 49, 49, 45); //フシギダネ
//        } else if (partnerPokemon.getAttack() > partnerPokemon.getLevel() * 10) {
//            return new Pokemon("Charmander", 39, 52, 43, 65); //ヒトカゲ
//        } else if (partnerPokemon.getSpeed() > partnerPokemon.getLevel() * 3) {
//            return new Pokemon("Squirtle", 44, 48, 65, 43); //ゼニガメ
//        } else {
//            return null;
//        }
//    }
//
//    /**
//     * @param number マイナスの場合は"Eevee"を返す <= Kotlin変換では引数"number"をnullableにする
//     *               "number"マイナスではなくnullの場合に"Eevee"にを返す
//     * @return 引数が0~7以外の場合はnullを返す
//     */
//    public static String evolveEevee(int number) {
//        // kotlin変換では、numberがnullで"Eevee"返す
//        if (number < 0) {
//            return "Eevee";
//        }
//
//        switch (number) {
//            case 0:
//            return "Vaporeon";
//            case 1:
//            return "Jolteon";
//            case 2:
//            return "Flareon";
//            case 3:
//            return "Espeon";
//            case 4:
//            return "Umbreon";
//            case 5:
//            return "Leafeon";
//            case 6:
//            return "Glaceon";
//            case 7:
//            return "Sylveon";
//            default:
//            return null;
//        }
//    }
//}
