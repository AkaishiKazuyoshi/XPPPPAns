package com.example.xpppp_for_senpai_devs.smart_home_tdd.right
//バルブB9000のクラスを宣言し、実装してください。
//B9000クラスはアキラくんの家に必要なインターフェースを継承してください。

class B9000: Bulb {
    override fun turnON() {
        print("turn on")
    }
    override fun turnOff() {
        print("turn off")
    }
}