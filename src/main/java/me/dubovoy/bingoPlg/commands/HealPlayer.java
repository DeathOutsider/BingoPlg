package me.dubovoy.bingoPlg.commands;

import me.dubovoy.bingoPlg.Msg;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HealPlayer implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (!(commandSender instanceof Player player)){
            commandSender.sendMessage("Only players can use this command.");
            return true;
        }

        if (!(player.hasPermission("bingoPlg.heal"))){
            Msg.send(player, "§eТолько оператор может пользоваться этой командой.");
            return true;
        }

        player.setHealth(20.0d);
        player.setSaturation(20.0F);

        Msg.send(player, "You were successfully healed", "&a");
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        return List.of();
    }
}
