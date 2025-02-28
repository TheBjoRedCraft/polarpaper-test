package dev.thebjoredcraft.polarpapertest

import com.github.shynixn.mccoroutine.bukkit.SuspendingJavaPlugin

val plugin get() = PolarpaperTest.getInstance()

class PolarpaperTest : SuspendingJavaPlugin() {

    override fun onEnable() {
        // Plugin startup logic
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    companion object {
        fun getInstance(): PolarpaperTest {
            return getPlugin(PolarpaperTest::class.java)
        }
    }
}
