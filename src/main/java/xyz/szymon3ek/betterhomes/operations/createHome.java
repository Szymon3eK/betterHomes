package xyz.szymon3ek.betterhomes.operations;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import xyz.szymon3ek.betterhomes.BetterHomes;

public class createHome extends BetterHomes {

    public static void create(int home, Player player) {

        BetterHomes plugin = BetterHomes.getPlugin(BetterHomes.class);

        FileConfiguration config = plugin.getConfig();

        config.set("homes." + player.getName() + "." + home + ".x", player.getLocation().getX());
        config.set("homes." + player.getName() + "." + home + ".y", player.getLocation().getY());
        config.set("homes." + player.getName() + "." + home + ".z", player.getLocation().getZ());
        config.set("homes." + player.getName() + "." + home + ".yaw", player.getLocation().getYaw());
        config.set("homes." + player.getName() + "." + home + ".pitch", player.getLocation().getPitch());
        config.set("homes." + player.getName() + "." + home + ".world", player.getWorld().getName());
        plugin.saveConfig();

        player.sendMessage("§a§l✓ §aUstawiono home! §a§l✓\n" + "§7X: §e" + Math.round(player.getLocation().getX() * 100.0) / 100.0 +" §7Y: §e" + Math.round(player.getLocation().getY() * 100.0) / 100.0 + " §7Z: §e " + Math.round(player.getLocation().getZ() * 100.0) / 100.0);
        player.sendTitle("§a§l✓ §aUstawiono home! §a§l✓", "§7X: §e" + Math.round(player.getLocation().getX() * 100.0) / 100.0 +" §7Y: §e" + Math.round(player.getLocation().getY() * 100.0) / 100.0 + " §7Z: §e " + Math.round(player.getLocation().getZ() * 100.0) / 100.0, 1, 60, 1);
        player.playSound(player.getLocation(), "minecraft:entity.player.levelup", 1, 1);


        player.closeInventory();
        player.updateInventory();

    }

}
