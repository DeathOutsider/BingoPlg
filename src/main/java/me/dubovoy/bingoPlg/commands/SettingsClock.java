package me.dubovoy.bingoPlg.commands;

import me.dubovoy.bingoPlg.Items.BingoItems;
import me.dubovoy.bingoPlg.Msg;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SettingsClock implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {

        if (!(commandSender instanceof Player player)){
            Msg.send(commandSender, "Only players can use this command");
            return true;
        }

        if (!(player.hasPermission("bingoPlg.settings_clock"))){
            Msg.send(commandSender, "§eТолько оператор может пользоваться этой командой.");
            return true;
        }

        ItemStack bingoClock = new BingoItems().BingoClock();
        player.getInventory().addItem(bingoClock);

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        return List.of();
    }
}
