package dev.thebjoredcraft.polarpapertest

import com.github.shynixn.mccoroutine.bukkit.SuspendingJavaPlugin
import dev.thebjoredcraft.polarpapertest.command.PolarPaperTestCommand
import org.bukkit.plugin.java.JavaPlugin

val plugin get() = JavaPlugin.getPlugin(PolarpaperTest::class.java)

class PolarpaperTest : SuspendingJavaPlugin() {
    override fun onEnable() {
        PolarPaperTestCommand("polarpapertest").register()
    }
}
