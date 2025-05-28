package me.dubovoy.bingoPlg.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class BingoItems {

    public ItemStack BingoCompass(){
        ItemStack compass = new ItemStack(Material.RECOVERY_COMPASS);
        ItemMeta compassMeta = compass.getItemMeta();
        compassMeta.addEnchant(Enchantment.KNOCKBACK, 1, false);
        compassMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        compassMeta.setLore(Collections.singletonList(ChatColor.DARK_PURPLE + "Нажмите ПКМ по воздуху, чтобы увидеть меню Bingo!"));
        compassMeta.setDisplayName(ChatColor.GOLD + "Bingo!");
        compass.setItemMeta(compassMeta);
        return compass;
    }

    public ItemStack BingoClock(){
        ItemStack clock = new ItemStack(Material.CLOCK);
        ItemMeta clockMeta = clock.getItemMeta();
        clockMeta.addEnchant(Enchantment.KNOCKBACK, 1, false);
        clockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        clockMeta.setLore(Collections.singletonList(ChatColor.DARK_PURPLE + "Нажмите ПКМ по воздуху, чтобы увидеть меню настроек Bingo!"));
        clockMeta.setDisplayName(ChatColor.GOLD + "Bingo! Settings");
        clock.setItemMeta(clockMeta);
        return clock;
    }

}
