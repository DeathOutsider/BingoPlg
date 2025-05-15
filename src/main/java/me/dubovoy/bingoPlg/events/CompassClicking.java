package me.dubovoy.bingoPlg.events;

import me.dubovoy.bingoPlg.BingoPlg;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.sql.SQLException;

public class CompassClicking implements Listener {

    private final BingoPlg bingoPlg;
    public CompassClicking(BingoPlg bingoPlg) {this.bingoPlg = bingoPlg;}

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if (item == null)
            return;
        ItemMeta meta = item.getItemMeta();
        if (meta.hasEnchant(Enchantment.KNOCKBACK) & item.getType() == Material.RECOVERY_COMPASS){
            System.out.println("That's IT!");
        } else{
            return;
        }
    }
}
