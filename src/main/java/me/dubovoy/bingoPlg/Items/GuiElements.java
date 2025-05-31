package me.dubovoy.bingoPlg.Items;

import me.dubovoy.bingoPlg.BingoPlg;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.CustomModelDataComponent;

import java.util.ArrayList;
import java.util.List;

public class GuiElements {

    public ItemStack playerInvMarkerPotion(){
        ItemStack playerInvItem = new ItemStack(Material.STRUCTURE_VOID);
        ItemMeta playerInvItemMeta = playerInvItem.getItemMeta();
        playerInvItemMeta.addEnchant(Enchantment.KNOCKBACK, 1, false);
        playerInvItemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        playerInvItemMeta.setDisplayName(ChatColor.GREEN + "Предмет вашего инвентаря");
        CustomModelDataComponent dataComponent = playerInvItemMeta.getCustomModelDataComponent();
        dataComponent.setStrings(List.of("1"));
        playerInvItemMeta.setCustomModelDataComponent(dataComponent);
        playerInvItem.setItemMeta(playerInvItemMeta);
        return playerInvItem;
    }

    public ItemStack teamInvMarkerPotion(){
        ItemStack teamInvItem = new ItemStack(Material.BARRIER);
        ItemMeta teamInvItemMeta = teamInvItem.getItemMeta();
        teamInvItemMeta.addEnchant(Enchantment.KNOCKBACK, 1, false);
        teamInvItemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        teamInvItemMeta.setDisplayName(ChatColor.YELLOW + "Предмет инвентаря команды");
        CustomModelDataComponent dataComponent = teamInvItemMeta.getCustomModelDataComponent();
        dataComponent.setStrings(List.of("1"));
        teamInvItemMeta.setCustomModelDataComponent(dataComponent);
        teamInvItem.setItemMeta(teamInvItemMeta);
        return teamInvItem;
    }

    public ItemStack invPlaceHolder(){
        ItemStack placeHolder = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta placeHolderMeta = placeHolder.getItemMeta();
        placeHolderMeta.setDisplayName(ChatColor.RESET + "");
        placeHolder.setItemMeta(placeHolderMeta);
        return placeHolder;
    }

    public ItemStack invSpaceHolder(){
        ItemStack spaceHolder = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
        ItemMeta spaceHolderMeta = spaceHolder.getItemMeta();
        spaceHolderMeta.setDisplayName(ChatColor.RESET + "");
        spaceHolder.setItemMeta(spaceHolderMeta);
        return spaceHolder;
    }

    public ItemStack button(String name, Material material){
        ItemStack redButton = new ItemStack(material);
        ItemMeta redButtonMeta = redButton.getItemMeta();
        redButtonMeta.setDisplayName(ChatColor.RESET + name);
        redButton.setItemMeta(redButtonMeta);
        return redButton;
    }

    public ItemStack redButton(String name){
        ItemStack redButton = new ItemStack(Material.RED_CONCRETE);
        ItemMeta redButtonMeta = redButton.getItemMeta();
        redButtonMeta.setDisplayName(ChatColor.RESET + name);
        redButton.setItemMeta(redButtonMeta);
        return redButton;
    }

    public ItemStack greenButton(String name){
        ItemStack greenButton = new ItemStack(Material.LIME_CONCRETE);
        ItemMeta greenButtonMeta = greenButton.getItemMeta();
        greenButtonMeta.setDisplayName(ChatColor.RESET + name);
        greenButton.setItemMeta(greenButtonMeta);
        return greenButton;
    }

}
