package me.dubovoy.bingoPlg.events;

import me.dubovoy.bingoPlg.BingoPlg;
import org.bukkit.Bukkit;
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
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.metadata.FixedMetadataValue;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class CompassClicking implements Listener {

    private final BingoPlg bingoPlg;
    public CompassClicking(BingoPlg bingoPlg) {this.bingoPlg = bingoPlg;}

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if (item == null)
            return;

        ItemMeta itemMeta = item.getItemMeta();
        if (!itemMeta.hasEnchant(Enchantment.KNOCKBACK) | item.getType() != Material.RECOVERY_COMPASS){
            return;
        }
        bingoPlg.LogIMsg(player.getName() + " Has been clicked with Bingo_Compass");

        try {
            String guiMeta = player.getName();
            Inventory guiPlayers = Bukkit.createInventory(player, 9 * 6, "Bingo!");
            List<Material> items = bingoPlg.getDb().getItems();
            int gridSize = bingoPlg.getDb().getGridSize();
            ItemStack placeHolder = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            ItemMeta placeHolderMeta = placeHolder.getItemMeta();
            placeHolderMeta.setDisplayName(" ");
            placeHolder.setItemMeta(placeHolderMeta);
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    guiPlayers.setItem(i * 9 + j, placeHolder);
                }
            }

            for (int i = 0; i < gridSize; i++) {
                for (int j = 0; j < gridSize; j++) {
                    guiPlayers.setItem(i * 9 + j, new ItemStack(items.get(i * gridSize + j)));
                }
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
