package de.mipa.addon;

import de.mipa.addon.commands.HelpC;
import de.mipa.addon.commands.gmC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.UUID;

public final class Addon extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("hilfe").setExecutor(new HelpC());
        getCommand("help").setExecutor(new HelpC());
        getCommand("?").setExecutor(new HelpC());
        getCommand("gm").setExecutor(new gmC());

        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage(ChatColor.DARK_GREEN + "Addon erfolgreich geladen!");


    }
    private static ArrayList<UUID> noplayersvisible;



    @Override
    public void onDisable() {

        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage(ChatColor.DARK_RED + "Addon erfolgreich gestoppt!");


    }
}
