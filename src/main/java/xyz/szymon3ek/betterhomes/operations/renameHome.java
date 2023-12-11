package xyz.szymon3ek.betterhomes.operations;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.szymon3ek.betterhomes.BetterHomes;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;


public class renameHome extends BetterHomes {

    static HashMap<Player, Integer> homeMap = new HashMap<>();

    static int sec = 15;


    public static void rename(int home, Player player) {
        player.closeInventory();
        player.updateInventory();

        player.sendTitle("§2Napisz na chacie nazwe home!", "§alub wpisz §a§lSTOP §aaby wyjsc", 1, 60, 1);
        player.sendMessage("§aNapisz na chacie nazwe swojego home! Masz na to " + sec + " sekund!");
        player.playSound(player.getLocation(), "minecraft:block.note_block.cow_bell", 1, 1);
        homeMap.put(player, home);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(homeMap.containsKey(player)) {
                    player.sendMessage("§c§l✗ §cAnulowano zmiane nazwy home! §c§l✗");
                    player.playSound(player.getLocation(), "minecraft:entity.villager.no", 1, 1);
                    homeMap.remove(player);
                }
            }
        }, sec * 1000L);
    }

    public static HashMap<Player, Integer> getMap() {
        return homeMap;
    }




}
