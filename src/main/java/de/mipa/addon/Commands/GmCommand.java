package de.mipa.addon.Commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GmCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + "Du musst ein Spieler sein");
            return false;
        }

        Player player = (Player) sender;
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("1")) {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage("§aSpielmodus gewechselt zu:§b Creativ");
            } else if (args[0].equalsIgnoreCase("0")) {
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage("§aSpielmodus gewechselt zu:§b Survival");
            } else if (args[0].equalsIgnoreCase("3")) {
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage("§aSpielmodus gewechselt zu:§b Spectator");
            } else if (args[0].equalsIgnoreCase("2")) {
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage("§aSpielmodus gewechselt zu:§b Adventure");
            } else {
                sender.sendMessage(ChatColor.RED + "Nutze /gm 0, 1 , 2 , 3");

            }


        }else   {
            sender.sendMessage(ChatColor.RED + "Nutze /gm 0, 1 , 2 , 3");

        }


        return false;
    }
}
