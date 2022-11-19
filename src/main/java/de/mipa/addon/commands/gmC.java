package de.mipa.addon.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gmC implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command arg1, String arg2, String[] args) {
        Player p=(Player)s;
        if (p.hasPermission("addon.gm")) {
            if(args.length==1) {
                if (args[0].equalsIgnoreCase("0")) {
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage("§aSpielmodus gewechselt zu:§b Survival");

                }else if(args[0].equalsIgnoreCase("1")){
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage("§aSpielmodus gewechselt zu:§b Creativ");

                }else if(args[0].equalsIgnoreCase("2")){
                    p.setGameMode(GameMode.ADVENTURE);
                    p.sendMessage("§aSpielmodus gewechselt zu:§b Adventure");

                }else if(args[0].equalsIgnoreCase("3")){
                    p.setGameMode(GameMode.SPECTATOR);
                    p.sendMessage("§aSpielmodus gewechselt zu:§b Spectator");



                }
            }
         }






        return false;
    }
}
