package me.dubovoy.bingoPlg.commands;

import me.dubovoy.bingoPlg.BingoPlg;
import me.dubovoy.bingoPlg.database.BingoTable;
import me.dubovoy.bingoPlg.logic.Difficulty;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
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

            BingoTable table = new BingoTable(bingoPlg);
            table.CreateBingoTable();


            bingoPlg.LogIMsg("Game Bingo! Was Started By " + commandSender.getName());
            bingoPlg.LogIMsg(table.getBingoItemsStringTable());
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
