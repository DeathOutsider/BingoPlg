package me.dubovoy.bingoPlg;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Collections;

public class CustomRecipes {

    public static void register(){

        ItemStack compass = new ItemStack(Material.RECOVERY_COMPASS);
        ItemMeta compassMeta = compass.getItemMeta();
        compassMeta.addEnchant(Enchantment.KNOCKBACK, 1, false);
        compassMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        compassMeta.setLore(Collections.singletonList(ChatColor.DARK_PURPLE + "Нажмите по воздуху, чтобы увидеть меню бинго!"));
        compassMeta.setDisplayName(ChatColor.GOLD + "Bingo!");
        compass.setItemMeta(compassMeta);

        ShapelessRecipe recipe_compass = new ShapelessRecipe(Keys.BINGO_COMPASS, compass);
        recipe_compass.addIngredient(new ItemStack(Material.DIRT));

        Bukkit.addRecipe(recipe_compass);
    }

}
