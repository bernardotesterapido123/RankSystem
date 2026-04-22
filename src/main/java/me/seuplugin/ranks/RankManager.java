package me.seuplugin.ranks;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.*;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class RankManager {

    private final Main plugin;
    private File file;
    private FileConfiguration data;

    public RankManager(Main plugin) {
        this.plugin = plugin;
        setup();
    }

    private void setup() {
        file = new File(plugin.getDataFolder(), "data.yml");

        if (!file.exists()) {
            try { file.createNewFile(); } catch (IOException e) { e.printStackTrace(); }
        }

        data = YamlConfiguration.loadConfiguration(file);
    }

    public void setRank(UUID uuid, String rank) {
        data.set(uuid.toString(), rank.toLowerCase());
        save();
    }

    public String getRank(UUID uuid) {
        return data.getString(uuid.toString(), "membro");
    }

    public String getPrefix(UUID uuid) {
        String rank = getRank(uuid);
        String path = "ranks." + rank + ".prefix";

        return plugin.getConfig().contains(path)
                ? plugin.getConfig().getString(path).replace("&", "§")
                : "§7[Membro]";
    }

    public List<Player> getPlayersByRank(String rank) {
        List<Player> players = new ArrayList<>();
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (getRank(p.getUniqueId()).equalsIgnoreCase(rank)) {
                players.add(p);
            }
        }
        return players;
    }

    public Set<String> getAllRanks() {
        return plugin.getConfig().getConfigurationSection("ranks").getKeys(false);
    }

    public boolean hasPermission(UUID uuid, String permission) {
        String rank = getRank(uuid);
        String path = "ranks." + rank + ".permissions";

        if (plugin.getConfig().contains(path)) {
            for (String perm : plugin.getConfig().getStringList(path)) {
                if (perm.equalsIgnoreCase("*") || perm.equalsIgnoreCase(permission)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void save() {
        try { data.save(file); } catch (IOException e) { e.printStackTrace(); }
    }
}