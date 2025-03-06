package de.mipa.addon.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ShopCommand implements CommandExecutor {

    private final JavaPlugin plugin;

    // Konstruktor nimmt das Plugin als Parameter, um die Konfiguration zu laden
    public ShopCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Nachricht aus der config.yml abrufen (Standardwert falls nicht gesetzt)
        FileConfiguration config = plugin.getConfig();
        String shopMessage = config.getString("shop-message", "§9Besuche unseren Shop auf www.shop.de");

        // Nachricht an den Spieler senden
        sender.sendMessage(shopMessage);
        return true;
    }
}
