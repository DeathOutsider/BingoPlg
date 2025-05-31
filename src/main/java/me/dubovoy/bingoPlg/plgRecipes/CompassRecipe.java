package me.dubovoy.bingoPlg.plgRecipes;

import me.dubovoy.bingoPlg.Items.BingoItems;
import me.dubovoy.bingoPlg.Keys;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.*;

public class CompassRecipe {

    public static void register(){

        BingoItems bingoItems = new BingoItems();
        ItemStack compass = bingoItems.BingoCompass();

        ShapelessRecipe recipe_compass = new ShapelessRecipe(Keys.BINGO_COMPASS, compass);
        recipe_compass.addIngredient(new ItemStack(Material.DIRT));

        Bukkit.addRecipe(recipe_compass);
    }

}
