package me.dubovoy.bingoPlg.Items;

import me.dubovoy.bingoPlg.BingoPlg;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuiElements {

    private final BingoPlg bingoPlg;
    public GuiElements(BingoPlg bingoPlg) {this.bingoPlg = bingoPlg;}

    public ItemStack playerInvMarkerPotion(){
//        ItemStack playerInvItem = new ItemStack(Material.POTION);
//        PotionMeta playerInvItemMeta = (PotionMeta) playerInvItem.getItemMeta();
//        playerInvItemMeta.addCustomEffect(new PotionEffect(PotionEffectType.GLOWING, 20, 0), false);
//        playerInvItemMeta.addEnchant(Enchantment.KNOCKBACK, 1, false);
//        playerInvItemMeta.addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP);
//        playerInvItemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
//        playerInvItemMeta.setDisplayName(ChatColor.GREEN + "Предмет вашего инвентаря");
//        playerInvItemMeta.setColor(Color.LIME);
//        playerInvItem.setItemMeta(playerInvItemMeta);

        ItemStack playerInvItem = new ItemStack(Material.STRUCTURE_VOID);
        ItemMeta playerInvItemMeta = playerInvItem.getItemMeta();
        playerInvItemMeta.addEnchant(Enchantment.KNOCKBACK, 1, false);
        playerInvItemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        playerInvItemMeta.setDisplayName(ChatColor.GREEN + "Предмет вашего инвентаря");
        playerInvItemMeta.setCustomModelData(1);
        playerInvItem.setItemMeta(playerInvItemMeta);
        return playerInvItem;
    }

    public ItemStack teamInvMarkerPotion(){
//        ItemStack teamInvItem = new ItemStack(Material.POTION);
//        PotionMeta teamInvItemMeta = (PotionMeta) teamInvItem.getItemMeta();
//        teamInvItemMeta.addCustomEffect(new PotionEffect(PotionEffectType.GLOWING, 20, 0), false);
//        teamInvItemMeta.addEnchant(Enchantment.KNOCKBACK, 1, false);
//        teamInvItemMeta.addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP);
//        teamInvItemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
//        teamInvItemMeta.setDisplayName(ChatColor.YELLOW + "Предмет инвентаря команды");
//        teamInvItemMeta.setColor(Color.YELLOW);
//        teamInvItem.setItemMeta(teamInvItemMeta);

        ItemStack teamInvItem = new ItemStack(Material.BARRIER);
        ItemMeta teamInvItemMeta = teamInvItem.getItemMeta();
        teamInvItemMeta.addEnchant(Enchantment.KNOCKBACK, 1, false);
        teamInvItemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        teamInvItemMeta.setDisplayName(ChatColor.YELLOW + "Предмет инвентаря команды");
        teamInvItemMeta.setCustomModelData(1);
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

}
