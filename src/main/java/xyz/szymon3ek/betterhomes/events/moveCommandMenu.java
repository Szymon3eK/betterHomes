package xyz.szymon3ek.betterhomes.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import xyz.szymon3ek.betterhomes.operations.createHome;
import xyz.szymon3ek.betterhomes.operations.deleteHome;
import xyz.szymon3ek.betterhomes.operations.teleportHome;
import xyz.szymon3ek.betterhomes.operations.renameHome;

public class moveCommandMenu implements Listener {


@EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        Inventory clickedInventory = event.getClickedInventory();
        Player player = (Player) event.getWhoClicked();

        if (clickedInventory != null && event.getView().getTitle().equals("§cBetterHomes")) {

            event.setCancelled(true);

            if (event.getCurrentItem().getType() == Material.LIME_BANNER) {
                if (event.getClick().isLeftClick() && !event.getClick().isShiftClick()) {
                    int home = event.getSlot();
                    teleportHome.teleport(home, player);
                } else if (event.getClick().isRightClick() && event.getClick().isShiftClick()) {
                    int home = event.getSlot();
                    deleteHome.delete(home, player);
                } else if(event.getClick().isLeftClick() && event.getClick().isShiftClick()) {
                    int home = event.getSlot();
                    renameHome.rename(home, player);
                }

            } else if (event.getCurrentItem().getType() == Material.RED_BANNER) {
                if (event.getClick().isLeftClick()) {
                    int home = event.getSlot();
                    createHome.create(home, player);

                }

            }
        }
    }
}
