package com.example.xpppp_for_senpai_devs.smart_home_tdd.right
//ディスプレイD9000のクラスを宣言し、実装してください。
//D9000クラスはアキラくんの家に必要なインターフェースを継承してください。
interface Display {
    fun displayBulbWarning()
}

class D9000: Display {
    override fun displayBulbWarning() {
        print("warning bulb!")
    }

}