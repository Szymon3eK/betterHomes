package xyz.szymon3ek.betterhomes.events;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import xyz.szymon3ek.betterhomes.BetterHomes;
import xyz.szymon3ek.betterhomes.operations.renameHome;

import java.util.HashMap;

public class renameevent implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {

        Player player = event.getPlayer();
        BetterHomes plugin = BetterHomes.getPlugin(BetterHomes.class);

        FileConfiguration config = plugin.getConfig();

        HashMap<Player, Integer> renameMap = renameHome.getMap();

        if(renameMap.containsKey(player)) {

            if(event.getMessage().equalsIgnoreCase("stop") || event.getMessage().equalsIgnoreCase("STOP")) {
                player.sendMessage("§c§l✗ §cAnulowano zmiane nazwy home! §c§l✗");
                event.setCancelled(true);
                renameMap.remove(event.getPlayer());
                player.playSound(player.getLocation(), "minecraft:entity.villager.no", 1, 1);
            } else {
                player.sendMessage("§a§l✓ §aZmieniono nazwe home §2§l" + renameMap.get(player) + " §ana §2§l" + event.getMessage());
                event.setCancelled(true);
                config.set("homes." + player.getName() + "." + renameMap.get(player) + ".name", event.getMessage());
                plugin.saveConfig();
                renameMap.remove(event.getPlayer());
                player.playSound(player.getLocation(), "minecraft:entity.player.levelup", 1, 1);
            }

        }



    }
}
