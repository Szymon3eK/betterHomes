package xyz.szymon3ek.betterhomes.operations;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import xyz.szymon3ek.betterhomes.BetterHomes;

public class deleteHome extends BetterHomes {

    public static void delete(int home, Player player) {

        BetterHomes plugin = BetterHomes.getPlugin(BetterHomes.class);

        FileConfiguration config = plugin.getConfig();

        float x = Math.round(config.getDouble("homes." + player.getName() + "." + home + ".x"));
        float y = Math.round(config.getDouble("homes." + player.getName() + "." + home + ".y"));
        float z = Math.round(config.getDouble("homes." + player.getName() + "." + home + ".z"));

        config.set("homes." + player.getName() + "." + home + ".x", null);
        config.set("homes." + player.getName() + "." + home + ".y", null);
        config.set("homes." + player.getName() + "." + home + ".z", null);
        config.set("homes." + player.getName() + "." + home + ".yaw", null);
        config.set("homes." + player.getName() + "." + home + ".pitch", null);
        config.set("homes." + player.getName() + "." + home + ".world", null);
        plugin.saveConfig();

        player.sendMessage("§c§l✗ §cUsunieto home! §c§l✗ \n" + "§7X: §e" + x +" §7Y: §e" + y + " §7Z: §e " + z);
        player.sendTitle("§c§l✗ §cUsunieto home! §c§l✗", "§7Pomyslnie usunales home!", 1, 60, 1);
        player.playSound(player.getLocation(), "minecraft:block.lava.extinguish", 1, 1);


        player.closeInventory();
        player.updateInventory();

    }
}
