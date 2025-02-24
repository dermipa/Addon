package de.mipa.addon.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HelpCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String messageHelp  = "§aWenn du hilfe brauchst nutze /ticket oder joine unserem Discord!";

        sender.sendMessage(messageHelp);
        return false;
    }
}