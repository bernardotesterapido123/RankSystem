package me.seuplugin.ranks;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class RanksCommand implements CommandExecutor {

    private final RanksMenu menu;

    public RanksCommand(RankManager manager) {
        this.menu = new RanksMenu(manager);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.openInventory(menu.getMenu());
        }

        return true;
    }
}
