package me.seuplugin.ranks;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.SkullMeta;

public class RankPlayersMenu {

    private final RankManager manager;

    public RankPlayersMenu(RankManager manager) {
        this.manager = manager;
    }

    public Inventory getMenu(String rank) {

        Inventory inv = Bukkit.createInventory(null, 54, "§8Rank: " + rank);

        for (Player player : manager.getPlayersByRank(rank)) {

            ItemStack head = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta meta = (SkullMeta) head.getItemMeta();

            meta.setOwningPlayer(player);
            meta.setDisplayName("§a" + player.getName());

            head.setItemMeta(meta);

            inv.addItem(head);
        }

        return inv;
    }
}