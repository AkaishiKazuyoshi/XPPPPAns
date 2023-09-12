package com.example.xpppp_for_senpai_devs.smart_home_tdd.right
//バルブB9000のクラスを宣言し、実装してください。
//B9000クラスはアキラくんの家に必要なインターフェースを継承してください。

class B9100: Bulb {
    override fun turnON() {
        print("turn on")
        //interfaceのおかげでlightOnで作ったらBulbとして使えないよを今わかる！
    }
    override fun turnOff() {
        print("turn off")
    }
}