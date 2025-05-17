package me.dubovoy.bingoPlg.events;

import me.dubovoy.bingoPlg.BingoPlg;
import me.dubovoy.bingoPlg.database.BingoTable;
import me.dubovoy.bingoPlg.gui.GuiElements;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.List;

public class CompassClicking implements Listener {

    private final BingoPlg bingoPlg;
    public CompassClicking(BingoPlg bingoPlg) {this.bingoPlg = bingoPlg;}

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if (item == null || !event.getAction().isRightClick())
            return;

        ItemMeta itemMeta = item.getItemMeta();
        if (!itemMeta.hasEnchant(Enchantment.KNOCKBACK) | item.getType() != Material.RECOVERY_COMPASS){
            return;
        }
        bingoPlg.LogIMsg(player.getName() + " Has been clicked with Bingo_Compass");

        try {
            String guiMeta = player.getName();
            Inventory guiPlayers = Bukkit.createInventory(player, 9 * 6, "Bingo!");
            BingoTable bingoTable = new BingoTable(bingoPlg);
            List<Material> items = bingoTable.getBingoItems();
            int gridSize = bingoPlg.getDb().getGridSize();
            GuiElements guiElements = new GuiElements(bingoPlg);

            ItemStack placeHolder = guiElements.invPlaceHolder();
            ItemStack spaceHolder = guiElements.invSpaceHolder();
            ItemStack playerInvItem = guiElements.playerInvMarkerPotion();
            ItemStack teamInvItem = guiElements.teamInvMarkerPotion();

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    guiPlayers.setItem(i * 9 + j, placeHolder);
                }
            }
            for (int i = 6; i < 9 * 6; i+=9) {
                guiPlayers.setItem(i, spaceHolder);

            }

            for (int i = 0; i < gridSize; i++) {
                for (int j = 0; j < gridSize; j++) {
                    guiPlayers.setItem(i * 9 + j, new ItemStack(items.get(i * gridSize + j)));
                }
            }


            List<ItemStack> playerItems = new ArrayList<>();
            Inventory playerInventory = player.getInventory();
            for (ItemStack invItem:playerInventory.getContents()){
                if (!playerItems.contains(invItem))
                    playerItems.add(invItem);
            }
            playerItems.remove(null);

            int counter = 0;
            for (ItemStack guiItem: guiPlayers){
                if (playerItems.contains(guiItem)){
                    guiPlayers.setItem(counter, playerInvItem);
                }
                counter++;
            }

            player.setMetadata("bingoGui", new FixedMetadataValue(bingoPlg, guiMeta));
            player.openInventory(guiPlayers);
        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }

    }

    @EventHandler
    public void onClickInvGui(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if (player.hasMetadata("bingoGui")) {
            event.setCancelled(true);

        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event){
        Player player = (Player) event.getPlayer();
        if(player.hasMetadata("bingoGui")){
            player.removeMetadata("bingoGui", bingoPlg);
        }
    }

}
