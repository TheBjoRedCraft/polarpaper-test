package dev.thebjoredcraft.polarpapertest.command

import dev.jorel.commandapi.CommandAPICommand

class PolarPaperTestCommand(commandName: String): CommandAPICommand(commandName) {
    init {
        withAliases("ppt")
        withPermission("polarpapertest.command.ppt")
        withSubcommand(PolarPaperCreateCommand("create"))
    }
}