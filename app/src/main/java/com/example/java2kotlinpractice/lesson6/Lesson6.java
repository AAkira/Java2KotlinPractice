package com.example.java2kotlinpractice.lesson6;

import com.example.java2kotlinpractice.lesson4.Pokemon;

import android.support.annotation.Nullable;

import java.util.Random;

public class Lesson6 {

    // battleターン間隔
    private static final int INTERVAL_DURATION = 2000;

    // 技のダメージは固定
    private static final int DAMAGE = 50;

    /**
     * Use Thread.sleep() in this method.
     */
    public static void battle(Pokemon partnerPokemon, Pokemon enemy, @Nullable EventListener listener) {

        final Pokemon first;
        final Pokemon last;

        // 先行, 後攻決め 本来勝負中に能力変化があるが、今回は変化しないため1回のみ
        if (partnerPokemon.getSpeed() > enemy.getSpeed()) {
            first = partnerPokemon;
            last = enemy;
        } else {
            first = enemy;
            last = partnerPokemon;
        }

        // battle
        while (true) {
            // 先行攻撃
            int damage = calcAttackDamage(first, last);
            last.setHp(last.getHp() - damage);
            if (listener != null) {
                listener.onAttacked(first, last, damage);
            }

            // hp確認
            if (last.getHp() <= 0) {
                if (listener != null) {
                    listener.onBattleEnd(first, last);
                }
                break;
            }

            try {
                Thread.sleep(INTERVAL_DURATION);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 後攻攻撃
            damage = calcAttackDamage(last, first);
            first.setHp(first.getHp() - damage);
            if (listener != null) {
                listener.onAttacked(last, first, damage);
            }

            // hp確認
            if (first.getHp() <= 0) {
                if (listener != null) {
                    listener.onBattleEnd(last, first);
                }
                break;
            }

            try {
                Thread.sleep(INTERVAL_DURATION);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * スコープ関数(run, let...)を上手く使うとreturnを消せる
     */
    private static int calcAttackDamage(Pokemon from, Pokemon to) {
        // 0.85 ~ 1.0
        final float rate = (new Random().nextInt(16) + 85) / 100f;
        return (int) (((from.getLevel() * 2 / 5f + 2) * DAMAGE * from.getAttack() / to.getDefence() / 50f + 2) * rate);
    }

    /**
     * interfaceの書き方はJavaとあまり変わらない
     */
    public interface EventListener {

        void onAttacked(Pokemon attacker, Pokemon defender, int damage);

        void onBattleEnd(Pokemon winner, Pokemon loser);
    }
}
