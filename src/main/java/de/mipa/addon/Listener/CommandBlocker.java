package de.mipa.addon.Listener;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandBlocker implements Listener {

    @EventHandler
    public void onCommandPreprocess(PlayerCommandPreprocessEvent event) {
        // Der Befehl, den der Spieler eingegeben hat
        String command = event.getMessage().toLowerCase();

        // Überprüfen, ob der Spieler den Befehl ausführen darf
        if (isCommandRestricted(command) && !hasPermission(event.getPlayer(), command)) {
            event.setCancelled(true); // Befehl blockieren
            event.getPlayer().sendMessage(ChatColor.RED + "Du hast keine Berechtigung für diesen Befehl.");
        }
    }

    // Diese Methode überprüft, ob der Befehl ein eingeschränkter Befehl ist
    private boolean isCommandRestricted(String command) {
        // Liste von Befehlen, die standardmäßig blockiert werden
        String[] restrictedCommands = {"/help", "/pl", "/plugins", "/version", "/about", "/?"};

        // Prüfen, ob der Befehl in der Liste enthalten ist
        for (String restrictedCommand : restrictedCommands) {
            if (command.startsWith(restrictedCommand)) {
                return true;
            }
        }
        return false; // Der Befehl ist nicht eingeschränkt
    }

    // Überprüfen, ob der Spieler eine Berechtigung für den Befehl hat
    private boolean hasPermission(CommandSender sender, String command) {
        // Berechtigungsschlüssel für den Befehl
        // Beispiel: Wenn der Befehl "/pl" blockiert werden soll, prüft man die Berechtigung "plugincommands.pl"
        String permissionNode = "plugincommands." + command.substring(1);  // Entfernt den führenden "/" vom Befehl

        // Überprüfen, ob der Spieler die Berechtigung hat
        return sender.hasPermission(permissionNode);
    }
}