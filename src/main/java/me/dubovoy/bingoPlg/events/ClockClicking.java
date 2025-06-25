package me.dubovoy.bingoPlg.events;

import me.dubovoy.bingoPlg.BingoPlg;
import me.dubovoy.bingoPlg.Items.GuiElements;
import me.dubovoy.bingoPlg.Msg;
import me.dubovoy.bingoPlg.game.BingoPlayer;
import me.dubovoy.bingoPlg.game.BingoTable;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;

public class ClockClicking implements Listener {

    private final BingoPlg bingoPlg;
    public ClockClicking(BingoPlg bingoPlg) {this.bingoPlg = bingoPlg;}

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if (item == null || !event.getAction().isRightClick())
            return;

        ItemMeta itemMeta = item.getItemMeta();
        if (!itemMeta.hasEnchant(Enchantment.KNOCKBACK) | item.getType() != Material.CLOCK){
            return;
        }
        if (bingoPlg.bLog)
            bingoPlg.LogIMsg("Player <" + player.getName() + "> Has been clicked with Settings_Clock");

        try {
            String guiMeta = player.getName();
            BingoPlayer bingoPlayer = new BingoPlayer(bingoPlg);
            player.setMetadata("settingsGui", new FixedMetadataValue(bingoPlg, guiMeta));
            player.openInventory(bingoPlayer.showSettingsGui(player));

        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }

    }

    @EventHandler
    public void onClickInvGui(final InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if (player.hasMetadata("settingsGui")) {
            event.setCancelled(true);
            if ((event.getAction() != InventoryAction.PICKUP_ALL) & (event.getAction() != InventoryAction.NOTHING) & (event.getAction() != InventoryAction.PICKUP_HALF))
                return;

            Inventory inv = event.getClickedInventory();
            if (inv == null)
                return;
//            bingoPlg.LogIMsg(inv.getType().toString());
            int slot = event.getSlot();
            ItemStack item = event.getCurrentItem();
            if (item == null | inv.getType() != InventoryType.CHEST)
                return;

            BingoTable bingoTable = new BingoTable(bingoPlg);
            GuiElements guiElements = new GuiElements();

            ItemMeta itemMeta = item.getItemMeta();
            String name = itemMeta.getDisplayName();
            String message = "";
            if (event.isRightClick() | event.isLeftClick()){
                if (name.contains("Mode")){
                    String newMode = "";
                    if (name.contains("CROSS"))
                        newMode = "TABLE";
                    else if (name.contains("TABLE"))
                        newMode = "CROSS";
                    message = bingoTable.setBingoMode(newMode);
                    event.getClickedInventory().setContents(new BingoPlayer(bingoPlg).showSettingsGui(player).getContents());
                    ItemStack btn = guiElements.button("Mode: " + newMode, Material.COMMAND_BLOCK);

                    event.setCurrentItem(btn);
                }
            }

            if (event.isLeftClick()){
                if (name.contains("Difficulty")){
                    int diff = bingoTable.getDifficulty() + 1;
                    if (diff > bingoPlg.maxDifficulty)
                        diff = bingoPlg.maxDifficulty;
                    message = bingoTable.setDifficulty(diff);
                    bingoTable.generateBingoTable();
                    event.getClickedInventory().setContents(new BingoPlayer(bingoPlg).showSettingsGui(player).getContents());
                    ItemStack btn = guiElements.button("Difficulty: " + diff, Material.CARVED_PUMPKIN);
                    btn.setAmount(diff);
                    event.setCurrentItem(btn);
                }
                if (name.contains("Grid Size")){
                    int size = bingoTable.getGridSize() + 1;
                    if (size > bingoPlg.maxGridSize)
                        size = bingoPlg.maxGridSize;
                    message = bingoTable.setGridSize(size);
                    bingoTable.generateBingoTable();
                    event.getClickedInventory().setContents(new BingoPlayer(bingoPlg).showSettingsGui(player).getContents());
                    ItemStack btn = guiElements.button("Grid Size: " + size, Material.SPAWNER);
                    btn.setAmount(size);
                    event.setCurrentItem(btn);
                }
                if (name.contains("Generate Table")){
                    bingoTable.generateBingoTable();
                    event.getClickedInventory().setContents(new BingoPlayer(bingoPlg).showSettingsGui(player).getContents());
                }
                if (name.contains("Items Config")){
                    event.getClickedInventory().close();
                    Inventory configInv =new BingoPlayer(bingoPlg).showItemsGui(player, 1);
                    player.setMetadata("configItemsGui", new FixedMetadataValue(bingoPlg, configInv));
                    player.openInventory(configInv);
                }

            }else if (event.isRightClick()){
                if (name.contains("Difficulty")){
                    int diff = bingoTable.getDifficulty() - 1;
                    if (diff < bingoPlg.minDifficulty)
                        diff = bingoPlg.minDifficulty;
                    message = bingoTable.setDifficulty(diff);
                    bingoTable.generateBingoTable();
                    event.getClickedInventory().setContents(new BingoPlayer(bingoPlg).showSettingsGui(player).getContents());
                    ItemStack btn = guiElements.button("Difficulty: " + diff, Material.CARVED_PUMPKIN);
                    btn.setAmount(diff);

                    event.setCurrentItem(btn);
                }
                if (name.contains("Grid Size")){
                    int size = bingoTable.getGridSize() - 1;
                    if (size < bingoPlg.minGridSize)
                        size = bingoPlg.minGridSize;
                    message = bingoTable.setGridSize(size);
                    bingoTable.generateBingoTable();
                    event.getClickedInventory().setContents(new BingoPlayer(bingoPlg).showSettingsGui(player).getContents());
                    ItemStack btn = guiElements.button("Grid Size: " + size, Material.SPAWNER);
                    btn.setAmount(size);

                    event.setCurrentItem(btn);
                }

            }
            if (!message.isEmpty()){
                Msg.send(player, message);
            }

        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event){
        Player player = (Player) event.getPlayer();
        if(player.hasMetadata("settingsGui"))
            player.removeMetadata("settingsGui", bingoPlg);
    }
}
