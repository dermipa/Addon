package de.mipa.addon.Listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.entity.Player;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String prefix = getPrefix(player); // Prefix basierend auf Permission holen

        // Chat-Format setzen
        event.setFormat(prefix + ChatColor.GRAY + player.getName() + " §8» " + ChatColor.WHITE + event.getMessage());
    }

    private String getPrefix(Player player) {
        if (player.hasPermission("addon.prefix.admin")) {
            return ChatColor.RED + "[Admin] ";
        } else if (player.hasPermission("addon.prefix.mod")) {
            return ChatColor.BLUE + "[Mod] ";
        } else if (player.hasPermission("addon.prefix.dev")) {
            return ChatColor.AQUA + "[Dev] ";
        } else {
            return ChatColor.GRAY + "[Spieler] ";
        }
    }
}