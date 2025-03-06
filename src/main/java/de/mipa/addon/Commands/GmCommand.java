package de.mipa.addon.Commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class GmCommand implements CommandExecutor {

    private final JavaPlugin plugin;

    public GmCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        FileConfiguration config = plugin.getConfig(); // Konfiguration laden

        // Nachricht für "Kein Spieler"
        String noPlayerMessage = config.getString("gm-messages.no-player", "§cDu musst ein Spieler sein, um diesen Befehl zu nutzen!");

        if (!(sender instanceof Player)) {
            sender.sendMessage(noPlayerMessage);
            return false;
        }

        Player player = (Player) sender;

        // Nachricht für falsche Nutzung
        String usageMessage = config.getString("gm-messages.usage", "§cNutze: /gm <0|1|2|3>");

        if (args.length != 1) {
            player.sendMessage(usageMessage);
            return false;
        }

        // Spielmodus-Nachrichten aus der Config laden
        String survivalMessage = config.getString("gm-messages.survival", "§aSpielmodus gewechselt zu:§b Survival");
        String creativeMessage = config.getString("gm-messages.creative", "§aSpielmodus gewechselt zu:§b Kreativ");
        String adventureMessage = config.getString("gm-messages.adventure", "§aSpielmodus gewechselt zu:§b Abenteuer");
        String spectatorMessage = config.getString("gm-messages.spectator", "§aSpielmodus gewechselt zu:§b Zuschauer");

        // Spielmodus setzen
        switch (args[0]) {
            case "1":
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(creativeMessage);
                break;
            case "0":
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(survivalMessage);
                break;
            case "2":
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage(adventureMessage);
                break;
            case "3":
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage(spectatorMessage);
                break;
            default:
                player.sendMessage(usageMessage);
                break;
        }

        return true;
    }
}
