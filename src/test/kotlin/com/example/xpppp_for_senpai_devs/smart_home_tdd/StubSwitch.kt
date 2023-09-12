package com.example.xpppp_for_senpai_devs.smart_home_tdd

import com.example.xpppp_for_senpai_devs.smart_home_tdd.right.Switch

//S9000クラスはアキラくんの家に必要なインターフェースを継承してください。

//スイッチS9000のクラスを宣言し、実装してください。


class StubSwitch: Switch {
    override var switchIsOnCounter = 0
    override fun isOn(): Boolean {
        switchIsOnCounter += 1
        return true
    }

    override fun isOnCounterReset() {
        TODO("Not yet implemented")
    }
}