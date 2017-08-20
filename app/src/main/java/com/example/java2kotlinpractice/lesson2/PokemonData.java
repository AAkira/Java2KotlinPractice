package com.example.java2kotlinpractice.lesson2;

public class PokemonData {

    final private String name;
    private int level;
    private int hp;

    public PokemonData(String name, int hp) {
        this(name, 5, hp);
    }

    public PokemonData(String name, int level, int hp) {
        this.name = name;
        this.level = level;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PokemonData)) {
            return false;
        }

        PokemonData that = (PokemonData) o;

        if (level != that.level) {
            return false;
        }
        if (hp != that.hp) {
            return false;
        }
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + level;
        result = 31 * result + hp;
        return result;
    }
}