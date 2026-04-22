package me.seuplugin.ranks;

import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

public class RanksMenu {

    private final RankManager manager;

    public RanksMenu(RankManager manager) {
        this.manager = manager;
    }

    public Inventory getMenu() {

        Inventory inv = Bukkit.createInventory(null, 27, "§8Ranks");

        int slot = 10;

        for (String rank : manager.getAllRanks()) {

            ItemStack item = new ItemStack(Material.NAME_TAG);
            ItemMeta meta = item.getItemMeta();

            meta.setDisplayName("§a" + rank.toUpperCase());
            meta.setLore(java.util.List.of("§7Clique para ver"));

            item.setItemMeta(meta);

            inv.setItem(slot++, item);
        }

        return inv;
    }
}