package me.seuplugin.ranks;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class SetRankCommand implements CommandExecutor {

    private final RankManager manager;

    public SetRankCommand(RankManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (args.length < 2) {
            sender.sendMessage("§cUse: /setrank <player> <rank>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage("§cJogador offline.");
            return true;
        }

        manager.setRank(target.getUniqueId(), args[1]);
        sender.sendMessage("§aRank definido!");
        return true;
    }
}