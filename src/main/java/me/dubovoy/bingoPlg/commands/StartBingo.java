package me.dubovoy.bingoPlg.commands;

import me.dubovoy.bingoPlg.BingoPlg;
import me.dubovoy.bingoPlg.Items.BingoItems;
import me.dubovoy.bingoPlg.Msg;
import me.dubovoy.bingoPlg.database.BingoTable;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class StartBingo implements CommandExecutor, TabExecutor {

    private final BingoPlg bingoPlg;
    public StartBingo(BingoPlg bingoPlg) {this.bingoPlg = bingoPlg;}

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        try {
            for (Player p: Bukkit.getOnlinePlayers()){
                ItemStack startItem = new BingoItems().BingoCompass();
                p.getInventory().clear();
                p.getInventory().addItem(startItem);
                p.playSound(p, Sound.ITEM_GOAT_HORN_SOUND_1, 100, 1);
                Msg.sendTitle(p, "§o§dBingo!", "§l§n§aНачалось!");
            }

            BingoTable table = new BingoTable(bingoPlg);
            if (!table.isBingoTableExists())
                table.createBingoTable();
            bingoPlg.LogIMsg("Game Bingo! Was Started By " + commandSender.getName());
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
