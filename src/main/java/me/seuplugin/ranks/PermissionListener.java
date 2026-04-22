package me.seuplugin.ranks;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PermissionListener implements Listener {

    private final RankManager manager;

    public PermissionListener(RankManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {

        String msg = e.getMessage().toLowerCase();

        // exemplo: comando /fly só VIP ou superior
        if (msg.startsWith("/fly")) {
            if (!manager.hasPermission(e.getPlayer().getUniqueId(), "vip.fly")) {
                e.getPlayer().sendMessage("§cVocê não tem permissão!");
                e.setCancelled(true);
            }
        }
    }
}