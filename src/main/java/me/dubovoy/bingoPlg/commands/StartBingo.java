package me.dubovoy.bingoPlg.commands;

import me.dubovoy.bingoPlg.BingoPlg;
import me.dubovoy.bingoPlg.logic.Difficulty;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StartBingo implements CommandExecutor, TabExecutor {

    private final BingoPlg bingoPlg;
    public StartBingo(BingoPlg bingoPlg) {this.bingoPlg = bingoPlg;}

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        try {
            for (Player p: Bukkit.getOnlinePlayers()){
                p.getInventory().clear();
                p.getInventory().addItem(new ItemStack(Material.DIRT));
            }

            try{
                bingoPlg.getDb().insertGame();
            } catch (SQLException e) {
                bingoPlg.LogErrorsMsg(e);
            }

            int itemsCount = bingoPlg.getDb().getGridSize() * bingoPlg.getDb().getGridSize();
            int quality = bingoPlg.getDb().getDifficulty();
            List<Material> items = new ArrayList<>();
            List<Material> materials = Difficulty.jsReader(bingoPlg.getInstance().getDataFolder().getAbsolutePath(), quality);

            Collections.shuffle(materials);
            for (int i = 0; i < itemsCount; i++) {
                items.add(materials.get(i));
            }
            bingoPlg.getDb().setItems(items);

        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        return List.of();
    }
}
