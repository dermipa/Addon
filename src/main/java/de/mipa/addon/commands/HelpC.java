package de.mipa.addon.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HelpC implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String messageHelp  = "§cMineVillage.de §8» §aWenn du hilfe brauchst nutze /ticket oder joine unserem Discord!";

        sender.sendMessage(messageHelp);
        return false;
    }
}
