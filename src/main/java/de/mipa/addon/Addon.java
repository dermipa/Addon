package de.mipa.addon;

import de.mipa.addon.commands.HelpC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Addon extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("hilfe").setExecutor(new HelpC());
        getCommand("help").setExecutor(new HelpC());
        getCommand("?").setExecutor(new HelpC());

        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage(ChatColor.DARK_GREEN + "Addon erfolgreich geladen!");



    }

    @Override
    public void onDisable() {

        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage(ChatColor.DARK_RED + "Lobbysystem erfolgreich gestoppt!");


    }
}
