package de.mipa.addon;

import de.mipa.addon.Commands.GmCommand;
import de.mipa.addon.Commands.HelpCommand;
import de.mipa.addon.Commands.ShopCommand;
import de.mipa.addon.EventHandler.JoinLeaveHandler;
import de.mipa.addon.Listener.ChatListener;
import de.mipa.addon.Listener.CommandBlocker;
import de.mipa.addon.Listener.JoinListener;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info(ChatColor.GREEN + "Addon wurde aktiviert!");

        getCommand("gm").setExecutor(new GmCommand());
        getCommand("shop").setExecutor(new ShopCommand());
        getCommand("hilfe").setExecutor(new HelpCommand());


        getServer().getPluginManager().registerEvents(new CommandBlocker(), this);
        getServer().getPluginManager().registerEvents(new JoinLeaveHandler(), this);
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.RED + "Addon wurde deaktiviert!");
    }

    public static Main getInstance() {
        return instance;
    }
}