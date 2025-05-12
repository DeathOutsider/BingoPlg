package me.dubovoy.bingoPlg.commands;

import me.dubovoy.bingoPlg.BingoPlg;
import me.dubovoy.bingoPlg.Msg;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CreateTableEx implements CommandExecutor, TabExecutor {

    private final BingoPlg bingoPlg;
    public CreateTableEx(BingoPlg bingoPlg) {this.bingoPlg = bingoPlg;}

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (!(commandSender instanceof Player player)){
            Msg.send(commandSender, "Only players can use this command");
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
//                String inv_title = strings[0]+" Inventory";
        String inv_title = "Inventory";

        int chance_to_get_inventory_item = 70;

        ItemStack placeHolder = new ItemStack(Material.MAGENTA_STAINED_GLASS_PANE);
        ItemStack nullItem = new ItemStack(Material.BARRIER);

        Inventory show_inventory = Bukkit.createInventory(player, inv_size, inv_title);
        List<Material> materials = Difficulty.jsReader(bingoPlg.getInstance().getDataFolder().getAbsolutePath(), quality);
        bingoPlg.LogWMsg(materials.toString());
//        Inventory inv_player = player.getInventory();
        for (int i = 0; i < inv_size; i++) {
            try {
                show_inventory.addItem(new ItemStack(materials.get(i + inv_size * (page-1))));
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
