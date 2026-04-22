package me.seuplugin.ranks;

import org.bukkit.event.*;
import org.bukkit.event.inventory.InventoryClickEvent;

public class RanksListener implements Listener {

    private final RankManager manager;

    public RanksListener(RankManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        if (!e.getView().getTitle().equals("§8Ranks")) return;

        e.setCancelled(true);

        if (e.getCurrentItem() == null) return;

        String rank = e.getCurrentItem().getItemMeta().getDisplayName()
                .replace("§a", "").toLowerCase();

        e.getWhoClicked().openInventory(
                new RankPlayersMenu(manager).getMenu(rank)
        );
    }
}