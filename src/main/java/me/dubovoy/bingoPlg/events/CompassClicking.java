package me.dubovoy.bingoPlg.events;

import me.dubovoy.bingoPlg.BingoPlg;
import me.dubovoy.bingoPlg.database.BingoPlayer;
import me.dubovoy.bingoPlg.database.BingoTable;
import me.dubovoy.bingoPlg.Items.GuiElements;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;

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
        bingoPlg.LogIMsg("<" + player.getName() + "> Has been clicked with Bingo_Compass");

        try {
            String guiMeta = player.getName();
            BingoPlayer bingoPlayer = new BingoPlayer(bingoPlg);
            player.setMetadata("bingoGui", new FixedMetadataValue(bingoPlg, guiMeta));
            player.openInventory(bingoPlayer.showGui(player));

        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }

    }
    
    @EventHandler
    public void onClickInvGui(final InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if (player.hasMetadata("bingoGui")) {
            event.setCancelled(true);
            if ((event.getAction() != InventoryAction.PICKUP_ALL) & (event.getAction() != InventoryAction.NOTHING) & (event.getAction() != InventoryAction.PICKUP_HALF))
                return;

            Inventory inv = event.getClickedInventory();
            if (inv == null)
                return;
//            bingoPlg.LogIMsg(inv.getType().toString());
            int slot = event.getSlot();
            ItemStack item = inv.getItem(slot);
            if (item == null | inv.getType() != InventoryType.CHEST)
                return;

            GuiElements guiElements = new GuiElements(bingoPlg);
            BingoTable bingoTable = new BingoTable(bingoPlg);

            ItemStack playerMarker = guiElements.playerInvMarkerPotion();
            ItemStack teamMarker = guiElements.teamInvMarkerPotion();
            List<Material> items = bingoTable.getBingoItems();

            if (item.getType() == teamMarker.getType() | item.getType() == playerMarker.getType() | items.contains(item.getType())){
                if (event.isLeftClick()){
                    int ind = bingoTable.convertIndToTable(slot);
                    event.setCurrentItem(new ItemStack(items.get(ind)));
                }
                else if (event.isRightClick()){
                    player.closeInventory();
                    String guiMeta = player.getName();
                    BingoPlayer bingoPlayer = new BingoPlayer(bingoPlg);
                    player.setMetadata("bingoGui", new FixedMetadataValue(bingoPlg, guiMeta));
                    player.openInventory(bingoPlayer.showGui(player));
                }
            }

        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event){
        Player player = (Player) event.getPlayer();
        if(player.hasMetadata("bingoGui"))
            player.removeMetadata("bingoGui", bingoPlg);
    }

}
