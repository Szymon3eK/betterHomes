package xyz.szymon3ek.betterhomes.operations;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import xyz.szymon3ek.betterhomes.BetterHomes;

public class teleportHome extends BetterHomes {

    public static void teleport(int home, Player player) {

        BetterHomes plugin = BetterHomes.getPlugin(BetterHomes.class);

        FileConfiguration config = plugin.getConfig();

        int teleporttime = config.getInt("config.teleporttime");



        float x = Math.round(config.getDouble("homes." + player.getName() + "." + home + ".x"));
        float y = Math.round(config.getDouble("homes." + player.getName() + "." + home + ".y"));
        float z = Math.round(config.getDouble("homes." + player.getName() + "." + home + ".z"));
        float yaw = Math.round(config.getDouble("homes." + player.getName() + "." + home + ".yaw"));
        float pitch = Math.round(config.getDouble("homes." + player.getName() + "." + home + ".pitch"));
        String world = config.getString("homes." + player.getName() + "." + home + ".world");

        player.teleport(new org.bukkit.Location(Bukkit.getWorld(world), x, y, z, yaw, pitch));
        player.playSound(player.getLocation(), "minecraft:entity.enderman.teleport", 1, 1);
        player.sendTitle("", "§aZostales przeteleportowany!", 1, 60, 1);

    }


}
