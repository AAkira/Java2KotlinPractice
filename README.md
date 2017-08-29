# Agenda

* Lesson1 : val, var
* Lesson2 : Data class
* Lesson3 : if, when, for, while
* Lesson4 : Null
* Lesson5 : Extension
* Lesson6 : Lambda 

# Points

* Lesson毎にKotlinに変換していきましょう
* Branch
  - master branch -> Java
  - kotlin branch -> Kotlinで解答を書いています
* Kotlinのコード規約は以下に従っています 
  - https://github.com/openfresh/android-kotlin-style-guide

## Lesson1

* final -> val
* 型推論
* 三項演算子 -> if-else

## Lesson2

* data class 
  - PokemonDataクラスは1行になる 
  - Default argumentsを使う
* Property access
  - `foo.setBar(bar)` , `foo.getBar()` -> `foo.bar = bar`, `foo.bar`  
* `${}` で変数にアクセス可能

## Lesson3

* Javaのswitch, if-else文はwhenに置き換え可能
* fibonacciは普通に変換しても良いが、 解答ではgenerateSequenceを用いて書いた(難易度高いのでやらなくて良い)

## Lesson4

* 複雑なのでPokemon, Itemは予めKotlin化済み
* Primitive型の引数にもnullを渡せる
* smart castを使ってnon-null型にする

## Lesson5

* run, let, apply(scope関数)を使って書いてみる
* 他にもalso, withがある(今回は使わなくても良い)

## Lesson6

* lambda式の変数はデフォルトだと `it`
   - 名前を付けることも出来る  `hoge { foo -> print(foo) }` 
* 今まで使ったscope関数, when 等を使う