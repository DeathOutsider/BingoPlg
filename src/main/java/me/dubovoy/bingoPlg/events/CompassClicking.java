package me.dubovoy.bingoPlg.events;

import me.dubovoy.bingoPlg.BingoPlg;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
            List<Material> items = bingoPlg.getDb().getItems();
            int gridSize = bingoPlg.getDb().getGridSize();
            ItemStack placeHolder = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            ItemMeta placeHolderMeta = placeHolder.getItemMeta();
            placeHolderMeta.setDisplayName(ChatColor.RESET + "");
            placeHolder.setItemMeta(placeHolderMeta);

            ItemStack spaceHolder = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
            ItemMeta spaceHolderMeta = placeHolder.getItemMeta();
            spaceHolderMeta.setDisplayName(ChatColor.RESET + "");
            spaceHolder.setItemMeta(spaceHolderMeta);

            ItemStack playerInvItem = new ItemStack(Material.POTION);
            PotionMeta playerInvItemMeta = (PotionMeta) playerInvItem.getItemMeta();
            playerInvItemMeta.addCustomEffect(new PotionEffect(PotionEffectType.GLOWING, 20, 0), false);
            playerInvItemMeta.addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP);
            playerInvItemMeta.setDisplayName(ChatColor.GREEN + "Предмет вашего инвентаря");
            playerInvItemMeta.setColor(Color.LIME);
            playerInvItem.setItemMeta(playerInvItemMeta);


            ItemStack teamInvItem = new ItemStack(Material.POTION);
            PotionMeta teamInvItemMeta = (PotionMeta) teamInvItem.getItemMeta();
            teamInvItemMeta.addCustomEffect(new PotionEffect(PotionEffectType.GLOWING, 20, 0), false);
            teamInvItemMeta.addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP);
            teamInvItemMeta.setDisplayName(ChatColor.YELLOW + "Предмет инвентаря команды");
            teamInvItemMeta.setColor(Color.YELLOW);
            teamInvItem.setItemMeta(teamInvItemMeta);

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
