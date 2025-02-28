package dev.thebjoredcraft.polarpapertest

import com.github.shynixn.mccoroutine.bukkit.SuspendingJavaPlugin
import dev.thebjoredcraft.polarpapertest.command.PolarPaperTestCommand

val plugin get() = PolarpaperTest.getInstance()

class PolarpaperTest : SuspendingJavaPlugin() {

    override fun onEnable() {
        PolarPaperTestCommand("polarpapertest").register()
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
