package com.example.java2kotlinpractice.lesson4

import android.support.annotation.IntRange
import java.util.Random

/**
 * base* ポケモンにおける種族値
 */

class Pokemon(val name: String, baseHp: Int, baseAttack: Int, baseDefence: Int, baseSpeed: Int, val level: Int = 5) {

    companion object {
        // ポケモンにおける個体値の最大値
        private val INDIVIDUAL_MAX_VALUE = 31
        // ポケモンにおける性格補正は1倍固定
        private val NATURE_VALUE = 1.0f
    }

    // Java用に作成した Kotlinだとdefault引数があるので不要
    constructor(name: String, baseHp: Int, baseAttack: Int, baseDefence: Int, baseSpeed: Int) :
            this(name, baseHp, baseAttack, baseDefence, baseSpeed, 5)

    var hp: Int = 0
        set(value) {
            field = if (value < 0) 0 else value
        }
    val attack: Int
    val defence: Int
    val speed: Int

    // ポケモンにおける努力値 (各パラメータに255まで割り当てられる. 全部の努力値の合計は510までだが今回は割愛)
    var effortHp: Int = 0
        set(@IntRange(from = 0, to = 255) value) { // 自動生成されるsetter, getterも書き換えられる
            field = value
        }
    var effortAttack: Int = 0
        set(@IntRange(from = 0, to = 255) value) {
            field = value
        }
    var effortDefence: Int = 0
        set(@IntRange(from = 0, to = 255) value) {
            field = value
        }
    var effortSpeed: Int = 0
        set(@IntRange(from = 0, to = 255) value) {
            field = value
        }

    // ポケモンにおける持ち物 (ポケモンは持ち物を1つ持てる)
    var heldItem: Item? = null

    // ポケモンにおける個体値 (本来はパラメータ毎に異なるが今回は割愛)
    private val individualValue: Int

    // 初期化の処理をinitに書ける ≒ Javaのコンストラクタ
    init {
        individualValue = Random().nextInt(INDIVIDUAL_MAX_VALUE + 1)
        this.hp = ((baseHp * 2f + individualValue.toFloat() + effortHp / 4f) * (level / 100f) + (10 + level)).toInt()
        this.attack = calcStatus(baseAttack, individualValue, effortAttack)
        this.defence = calcStatus(baseDefence, individualValue, effortDefence)
        this.speed = calcStatus(baseSpeed, individualValue, effortSpeed)
    }

    private fun calcStatus(baseValue: Int, individualValue: Int, effortValue: Int) =
            (((baseValue * 2f + individualValue.toFloat() + effortValue / 4f) * (level / 100f) + 5) * NATURE_VALUE).toInt()
}

//public class Pokemon {
//
//    // ポケモンにおける個体値の最大値
//    private static final int INDIVIDUAL_MAX_VALUE = 31;
//    // ポケモンにおける性格補正は1倍固定
//    private static final float NATURE_VALUE = 1.0f;
//
//    final private String name;
//    private int level;
//    private int hp;
//    private int attack;
//    private int defence;
//    private int speed;
//
//    // ポケモンにおける努力値 (各パラメータに255まで割り当てられる. 全部の努力値の合計は510までだが今回は割愛)
//    @IntRange(from = 0, to = 255)
//    private int effortHp;
//    @IntRange(from = 0, to = 255)
//    private int effortAttack;
//    @IntRange(from = 0, to = 255)
//    private int effortDefence;
//    @IntRange(from = 0, to = 255)
//    private int effortSpeed;
//
//    public Pokemon(String name, int hp, int attack, int defence, int speed) {
//        this(name, 5, hp, attack, defence, speed);
//    }
//
//    public Pokemon(String name, int level, int hp, int attack, int defence, int speed) {
//        this.name = name;
//        this.level = level;
//        final int individualValue = new Random().nextInt(INDIVIDUAL_MAX_VALUE + 1);
//        this.hp = (int) ((hp * 2f + individualValue + effortHp / 4f) * (level / 100f) + (10 + level));
//        this.attack = (int) (((attack * 2f + individualValue + effortAttack / 4f) * (level / 100f) + 5) * NATURE_VALUE);
//        this.defence = (int) (((defence * 2f + individualValue + effortDefence / 4f) * (level / 100f) + 5) * NATURE_VALUE);
//        this.speed = (int) (((speed * 2f + individualValue + effortSpeed / 4f) * (level / 100f) + 5) * NATURE_VALUE);
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getLevel() {
//        return level;
//    }
//
//    public int getHp() {
//        return hp;
//    }
//
//    public void setHp(int hp) {
//        if (hp < 0) {
//            hp = 0;
//        }
//        this.hp = hp;
//    }
//
//    public int getAttack() {
//        return attack;
//    }
//
//    public int getDefence() {
//        return defence;
//    }
//
//    public int getSpeed() {
//        return speed;
//    }
//
//    public void setEffortHp(int effortHp) {
//        this.effortHp = effortHp;
//    }
//
//    public void setEffortAttack(int effortAttack) {
//        this.effortAttack = effortAttack;
//    }
//
//    public void setEffortDefence(int effortDefence) {
//        this.effortDefence = effortDefence;
//    }
//
//    public void setEffortSpeed(int effortSpeed) {
//        this.effortSpeed = effortSpeed;
//    }
//}