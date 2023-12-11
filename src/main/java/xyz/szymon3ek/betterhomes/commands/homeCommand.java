package xyz.szymon3ek.betterhomes.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import xyz.szymon3ek.betterhomes.BetterHomes;

import java.util.ArrayList;
import java.util.List;

public class homeCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("home")) {

            Player player = (Player) sender;
            Inventory menu = player.getServer().createInventory(null, InventoryType.HOPPER, "§cBetterHomes");

            Plugin plugin = BetterHomes.getPlugin(BetterHomes.class);
            FileConfiguration config = plugin.getConfig();

            int maxhomes = config.getInt("config.maxhomes");

            for (int i = 1; i <= maxhomes; i++) {

                if(config.contains("homes." + player.getName() + '.'+ i + ".x")) {

                    ItemStack homes = new ItemStack(Material.LIME_BANNER);
                    float x = Math.round(config.getDouble("homes." + player.getName() + "." + i + ".x"));
                    float y = Math.round(config.getDouble("homes." + player.getName() + "." + i + ".y"));
                    float z = Math.round(config.getDouble("homes." + player.getName() + "." + i + ".z"));
                    float yaw = Math.round(config.getDouble("homes." + player.getName() + "." + i + ".yaw"));
                    float pitch = Math.round(config.getDouble("homes." + player.getName() + "." + i + ".pitch"));
                    String world = config.getString("homes." + player.getName() + "." + i + ".world");

                    ItemMeta homesmeta = homes.getItemMeta();
                    homesmeta.setDisplayName("§7» §6§l DOM " + i);
                    List<String> homeslore = new ArrayList<>();

                    if(config.contains("homes." + player.getName() + "." + i + ".name")) {
                        homeslore.add("§7Nazwa: §6"+ config.getString("homes." + player.getName() + "." + i + ".name"));
                    } else {
                        homeslore.add("§7Nazwa: §cNie masz ustalonej nazwy domu!");
                    }

                    homeslore.add("§7X: §a" + x + " §7Y: §a" + y + " §7Z: §a" + z); homeslore.add("§7Swiat: §a" + world); homeslore.add(" "); homeslore.add("§a§lLPM §7- Kliknij aby sie teleportowac!"); homeslore.add("§c§lSHIFT + PPM §7- Kliknij aby usunac home!"); homeslore.add("§6§lSHIFT + LPM §7- Kliknij aby nadac nazwe!");
                    homesmeta.setLore(homeslore);
                    homes.setItemMeta(homesmeta);

                    menu.setItem(i, homes);

                } else {
                    ItemStack emptyhomes = new ItemStack(Material.RED_BANNER);

                    ItemMeta emptyhomesmeta = emptyhomes.getItemMeta();
                    emptyhomesmeta.setDisplayName("§7» §6§l DOM " + i);
                    List<String> emptyhomeslore = new ArrayList<>(); emptyhomeslore.add("§7Nie masz jeszcze wybranego home!"); emptyhomeslore.add("§eKliknij aby nadac home!");
                    emptyhomesmeta.setLore(emptyhomeslore);
                    emptyhomes.setItemMeta(emptyhomesmeta);

                    menu.setItem(i, emptyhomes);
                }


            }

            for (int i = 3; i > maxhomes; i--) {

                ItemStack maxhomesbanner = new ItemStack(Material.BLACK_BANNER);

                ItemMeta maxhomesmeta = maxhomesbanner.getItemMeta();
                maxhomesmeta.setDisplayName("§7» §c§l✗ ");
                List<String> maxhomeslore = new ArrayList<>(); maxhomeslore.add("§7Nie mozesz ustawic wiecej homow!");
                maxhomesmeta.setLore(maxhomeslore);
                maxhomesbanner.setItemMeta(maxhomesmeta);

                menu.setItem(i, maxhomesbanner);


            }

            menu.setItem(0, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
            menu.setItem(4, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
            player.openInventory(menu);player.playSound(player.getLocation(), "minecraft:block.conduit.activate", 1, 1);
            return true;
        }
        return false;
    }
}
