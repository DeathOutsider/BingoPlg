package me.dubovoy.bingoPlg;

import me.dubovoy.bingoPlg.Items.BingoItems;
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

        BingoItems bingoItems = new BingoItems();
        ItemStack compass = bingoItems.BingoCompass();

        ShapelessRecipe recipe_compass = new ShapelessRecipe(Keys.BINGO_COMPASS, compass);
        recipe_compass.addIngredient(new ItemStack(Material.DIRT));

        Bukkit.addRecipe(recipe_compass);
    }

}
