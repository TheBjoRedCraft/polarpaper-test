package dev.thebjoredcraft.polarpapertest.command

import com.github.shynixn.mccoroutine.bukkit.launch
import dev.jorel.commandapi.CommandAPICommand
import dev.jorel.commandapi.arguments.IntegerArgument
import dev.jorel.commandapi.executors.PlayerCommandExecutor
import dev.thebjoredcraft.polarpapertest.plugin
import live.minehub.polarpaper.Polar
import net.kyori.adventure.text.Component
import org.bukkit.WorldCreator
import java.util.*
import kotlin.system.measureTimeMillis

class PolarPaperCreateCommand(commandName: String) : CommandAPICommand(commandName) {
    init {
        withOptionalArguments(IntegerArgument("amount"))

        executesPlayer(PlayerCommandExecutor() { player, args ->
            val amount = args.getOrDefaultUnchecked("amount", 1)
            val times = mutableListOf<Long>()

            plugin.launch {
                val totalTime = measureTimeMillis {
                    repeat(amount) {
                        times.add(measureTimeMillis {
                            Polar.createPolarWorld(
                                WorldCreator.name(UUID.randomUUID().toString())
                            )
                        })
                    }
                }

                val minTime = times.minOrNull()
                val avgTime = times.average()
                val maxTime = times.maxOrNull()

                val builder = Component.text()
                builder.append(Component.text("Created $amount worlds in $totalTime ms"))
                builder.append(Component.newline())
                builder.append(Component.newline())
                builder.append(Component.text("Min: $minTime ms"))
                builder.append(Component.newline())
                builder.append(Component.text("Avg: $avgTime ms"))
                builder.append(Component.newline())
                builder.append(Component.text("Max: $maxTime ms"))

                player.sendMessage(builder.build())
            }
        })
    }
}