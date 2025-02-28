package dev.thebjoredcraft.polarpapertest.command

import com.github.shynixn.mccoroutine.bukkit.launch
import dev.jorel.commandapi.CommandAPICommand
import dev.jorel.commandapi.arguments.IntegerArgument
import dev.jorel.commandapi.executors.PlayerCommandExecutor
import dev.thebjoredcraft.polarpapertest.plugin

import live.minehub.polarpaper.Polar
import net.kyori.adventure.text.Component

import org.bukkit.WorldCreator

import java.util.UUID

class PolarPaperCreateCommand(commandName: String): CommandAPICommand(commandName) {
    init {
        withArguments(IntegerArgument("amount"))

        executesPlayer(PlayerCommandExecutor() { player, args ->
            val amount: Int = args.getUnchecked<Int>("amount") ?: return@PlayerCommandExecutor

            plugin.launch {
                val start = System.currentTimeMillis()

                repeat(amount) {
                    Polar.createPolarWorld(WorldCreator.name(UUID.randomUUID().toString()))
                }

                val ending = System.currentTimeMillis()

                player.sendMessage(Component.text("Created $amount polar worlds in ${ending - start}ms"))
            }
        })
    }
}