package com.example.xpppp_for_senpai_devs.smart_home_tdd.right
//スイッチS9000のクラスを宣言し、実装してください。
//S9000クラスはアキラくんの家に必要なインターフェースを継承してください。

interface Switch {
    fun isOn(): Boolean
}

class S9000: Switch {
    override fun isOn(): Boolean {
        return true
    }

}