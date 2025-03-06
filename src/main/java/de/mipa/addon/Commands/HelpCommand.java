package de.mipa.addon.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class HelpCommand implements CommandExecutor {

    private final JavaPlugin plugin;

    // Konstruktor erwartet das Plugin als Parameter
    public HelpCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Konfigurationsdatei abrufen
        FileConfiguration config = plugin.getConfig();

        // Nachricht aus der Config laden (Standardwert, falls nicht vorhanden)
        String messageHelp = config.getString("help-message", "§aStandard-Hilfenachricht falls nicht konfiguriert!");

        // Nachricht an den Spieler senden
        sender.sendMessage(messageHelp);
        return true;
    }
}
