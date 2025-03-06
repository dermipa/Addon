package de.mipa.addon.Listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // Tablist-Prefix setzen
        setTablistPrefix(player);
    }

    private void setTablistPrefix(Player player) {
        Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = board.getTeam(player.getName());

        if (team == null) {
            team = board.registerNewTeam(player.getName());
        }


        // Prefix basierend auf Permission setzen
        if (player.hasPermission("addon.prefix.owner")) {
            team.setPrefix(ChatColor.DARK_RED + "[Owner] ");
        } else if (player.hasPermission("addon.prefix.admin")) {
            team.setPrefix(ChatColor.RED + "[Admin] ");
        } else if (player.hasPermission("addon.prefix.dev")) {
            team.setPrefix(ChatColor.AQUA + "[Dev] ");
        } else if (player.hasPermission("addon.prefix.mod")) {
            team.setPrefix(ChatColor.GREEN + "[Moderator] ");
        } else if (player.hasPermission("addon.prefix.sup")) {
            team.setPrefix(ChatColor.BLUE + "[Supporter] ");
        } else if (player.hasPermission("addon.prefix.premium")) {
            team.setPrefix(ChatColor.GOLD + "[Premium] ");
        } else {
            team.setPrefix(ChatColor.GRAY + "[Spieler] ");
        }

        team.addEntry(player.getName());
        player.setScoreboard(board);


    }

}