package me.seuplugin.ranks;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private RankManager rankManager;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        rankManager = new RankManager(this);

        getCommand("setrank").setExecutor(new SetRankCommand(rankManager));
        getCommand("rank").setExecutor(new RankCommand(rankManager));
        getCommand("ranks").setExecutor(new RanksCommand(rankManager));

        getServer().getPluginManager().registerEvents(new ChatListener(rankManager), this);
        getServer().getPluginManager().registerEvents(new GUIListener(rankManager), this);
        getServer().getPluginManager().registerEvents(new RanksListener(rankManager), this);
        getServer().getPluginManager().registerEvents(new PermissionListener(rankManager), this);

        getLogger().info("RankSystem ativado!");
    }
}