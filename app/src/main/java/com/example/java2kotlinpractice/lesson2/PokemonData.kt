package com.example.java2kotlinpractice.lesson2

class PokemonData(val name: String?, var level: Int = 5, var hp: Int)
// setter, getter, equals等が自動生成される
// default引数を使うことでコンストラクタも1つに出来る