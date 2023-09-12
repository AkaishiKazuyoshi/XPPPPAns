package com.example.xpppp_for_senpai_devs.smart_home_tdd.right
//ヒント
//DIPの講義で使用したAE86のコードを参考にしましょう。
//wrongフォルダに良くない例としてスマートホームのサンプルコードを示してあります。
//サンプルコード（wrongフォルダ内）を良くみてDIPに則った形に書き直してください。
//まずは必要なインターフェースを実装しましょう
//次にアキラくんの家（class AkiraHouse)を宣言し実装しましょう
//アキラくんの家はSmartHomeのインターフェースを継承する形で定義してください。
//アキラくんの家は依存関係を注入できるようにコンストラクターの引数を設定しましょう。

interface Bulb {
    fun turnON()
    fun turnOff()
}
interface Switch {
    fun isOn(): Boolean
    var switchIsOnCounter: Int
}
interface Display {
    fun displayBulbWarning()
}

class AkiraHouse(val bulb: Bulb, val switch: Switch, val display: Display): SmartHouse {
    override var bulbWarning = false
    override fun run() {
        lighting(bulb, switch)
        if (bulbWarning) {
            display.displayBulbWarning()
        }
    }

    private fun lighting(bulb: Bulb, switch: Switch) {
        if(switch.isOn()) {
            bulb.turnON()
        } else {
            bulb.turnOff()
        }
    }
}

