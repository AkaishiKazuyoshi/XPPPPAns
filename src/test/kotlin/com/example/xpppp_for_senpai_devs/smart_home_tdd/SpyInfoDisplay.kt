package com.example.xpppp_for_senpai_devs.smart_home_tdd

import com.example.xpppp_for_senpai_devs.smart_home_tdd.right.Display

//ディスプレイD9000のクラスを宣言し、実装してください。
//D9000クラスはアキラくんの家に必要なインターフェースを継承してください。


class SpyInfoDisplay: Display {
    var displayBulbWarinigWasCalled = false
    override fun displayBulbWarning() {
        print("warning bulb!")
        displayBulbWarinigWasCalled = true
    }

}