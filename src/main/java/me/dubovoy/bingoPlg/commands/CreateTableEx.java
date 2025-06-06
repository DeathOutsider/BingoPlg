package me.dubovoy.bingoPlg.commands;

import me.dubovoy.bingoPlg.BingoPlg;
import me.dubovoy.bingoPlg.Msg;
import me.dubovoy.bingoPlg.database.BingoDb;
import me.dubovoy.bingoPlg.logic.Difficulty;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.OminousBottleMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreateTableEx implements CommandExecutor, TabExecutor {

    private final BingoPlg bingoPlg;
    public CreateTableEx(BingoPlg bingoPlg) {this.bingoPlg = bingoPlg;}

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (!(commandSender instanceof Player player)){
            Msg.send(commandSender, "Only players can use this command");
            try {
                if (strings.length != 1)
                    return true;
                int ind = Integer.parseInt(strings[0]);
                System.out.println(bingoPlg.getDb().getIdItemsForDifficulty(ind));
                System.out.println(bingoPlg.getDb().getIdItemsForDifficulty(ind).size());

            } catch (SQLException e) {
                bingoPlg.LogErrorsMsg(e);
            }
            return true;
        }

        if (strings.length < 1){
            Msg.send(player, "Введите уровень айтемов");
            return true;
        } else if (strings.length < 2){
            Msg.send(player, "Введите страницу");
            return true;
        }



        int quality = Integer.parseInt(strings[0]);
        int page = Integer.parseInt(strings[1]);

        int inv_size = 9*6;
        int sh_size = 9*5;
        String inv_title = "Inventory";

        Inventory show_inventory = Bukkit.createInventory(player, inv_size, inv_title);
//        List<Material> materials = Difficulty.readBingoFiles(bingoPlg.getInstance().getDataFolder().getAbsolutePath(), quality);
        List<Material> materials = new ArrayList<>();
        try {
            materials = bingoPlg.getDb().getAllItemsForDifficulty(quality);

        } catch (SQLException e) {
            bingoPlg.LogErrorsMsg(e);
        }
        bingoPlg.LogWMsg(materials.toString());
        for (int i = 0; i < sh_size; i++) {
            try {
                show_inventory.addItem(new ItemStack(materials.get(i + sh_size * (page-1))));
            } catch (Exception e) {
                show_inventory.addItem(new ItemStack(Material.AIR));
            }
        }
        player.openInventory(show_inventory);
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        return List.of();
    }
}
