package com.example.xpppp_for_senpai_devs.smart_home_tdd

import com.example.xpppp_for_senpai_devs.smart_home_tdd.right.AkiraHouse
import com.example.xpppp_for_senpai_devs.smart_home_tdd.right.B9000
import com.example.xpppp_for_senpai_devs.smart_home_tdd.right.D9000
import com.example.xpppp_for_senpai_devs.smart_home_tdd.right.S9000
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SmartHomeTest {
    //ここにテストを記述してください。
    //必要なTestDoubleは自分たちで設定しましょう。
    //TestDoubleを作るのにmockkなどの便利なライブラリがありますが今回は使用しないでください。
    @Test
    fun `test_bulbwaringがtrueの時電球を交換してくださいと警告が出る`() {
        val bulb = B9000()
        val switch = S9000()
        val spyDisplay = SpyInfoDisplay()
        val house = AkiraHouse(bulb, switch, spyDisplay)
        house.bulbWarning = true
        house.run()

        assertTrue(spyDisplay.displayBulbWarinigWasCalled)
    }

    @Test
    fun `test_SwitchのisOnメソッドが押された回数を保存できる`() {
        val switch = S9000()


        assertEquals(switch.switchIsOnCounter, 0)
        switch.isOn()
        assertEquals(switch.switchIsOnCounter, 1)
        switch.isOn()
        assertEquals(switch.switchIsOnCounter, 2)
        switch.isOn()
        assertEquals(switch.switchIsOnCounter, 3)
    }
}