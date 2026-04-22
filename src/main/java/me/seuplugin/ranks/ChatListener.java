package me.seuplugin.ranks;

import org.bukkit.event.*;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    private final RankManager rankManager;

    public ChatListener(RankManager rankManager) {
        this.rankManager = rankManager;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        String prefix = rankManager.getPrefix(e.getPlayer().getUniqueId());
        e.setFormat(prefix + " " + e.getPlayer().getName() + " §7» §f" + e.getMessage());
    }
}