package com.example.xpppp_for_senpai_devs.smart_home_tdd

import com.example.xpppp_for_senpai_devs.smart_home_tdd.right.AkiraHouse
import com.example.xpppp_for_senpai_devs.smart_home_tdd.right.B9000
import com.example.xpppp_for_senpai_devs.smart_home_tdd.right.D9000
import com.example.xpppp_for_senpai_devs.smart_home_tdd.right.S9000
import com.sun.source.tree.AssertTree
import org.junit.jupiter.api.Assertions.*
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
        switch.switchIsOnCounter = 2 //後の実装で0だとbulbWarinigをfalseにしてしまうため、追加
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

    @Test
    fun `test_swichIsOnCounterが5になったらbulbWarningをtrueにする`() {
        val bulb = B9000()
        val stubSwitch = StubSwitch()
        stubSwitch.switchIsOnCounter = 5
        val display = D9000()
        val house = AkiraHouse(bulb, stubSwitch, display)

        house.run()

        assertTrue(house.bulbWarning)
    }

    @Test
    fun `test_isOnCounterResetが呼ばれたらisOnCounterを0にする`() {
        val switch = S9000()
        switch.switchIsOnCounter = 100
        switch.isOnCounterReset()
        assertEquals(switch.switchIsOnCounter, 0)
    }

    @Test
    fun `test_isOnCounterが0の時bulbWarningをfalseにする`() {
        val bulb = B9000()
        val switch = S9000()
        switch.switchIsOnCounter = 1000
        val display = D9000()
        val house = AkiraHouse(bulb, switch, display)
        house.bulbWarning = true

        switch.isOnCounterReset()
        house.run()

        assertFalse(house.bulbWarning)
    }
}