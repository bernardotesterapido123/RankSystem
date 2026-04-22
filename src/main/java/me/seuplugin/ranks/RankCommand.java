package me.seuplugin.ranks;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RankCommand implements CommandExecutor {

    private final RankManager manager;

    public RankCommand(RankManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            String rank = manager.getRank(player.getUniqueId());
            player.sendMessage("§aSeu rank: §f" + rank);
        } else {
            sender.sendMessage("Apenas jogadores podem usar esse comando.");
        }

        return true;
    }
}
