package com.example.xpppp_for_senpai_devs.smart_home_tdd.right
//S9000クラスはアキラくんの家に必要なインターフェースを継承してください。

//スイッチS9000のクラスを宣言し、実装してください。


class S9000: Switch {
    override fun isOn(): Boolean {
        return true
    }
}