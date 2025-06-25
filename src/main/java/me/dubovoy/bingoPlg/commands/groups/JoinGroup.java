package me.dubovoy.bingoPlg.commands.groups;

import me.dubovoy.bingoPlg.BingoPlg;
import me.dubovoy.bingoPlg.Msg;
import me.dubovoy.bingoPlg.game.BingoTeam;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class JoinGroup implements CommandExecutor, TabExecutor {

    private final BingoPlg bingoPlg;
    public JoinGroup(BingoPlg bingoPlg) {this.bingoPlg = bingoPlg;}

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (!(commandSender instanceof Player player)){
            Msg.send(commandSender, "Only players can use this command");
            return true;
        }

        if (strings.length != 1){
            Msg.send(player, "Введите название вашей группы к которой хотите присоединится!");
            return true;
        }

        String teamName = strings[0].toLowerCase();
        BingoTeam bingoTeam = new BingoTeam(bingoPlg);
        String message = bingoTeam.playerJoinTeam(player, teamName);
        Msg.send(player, message);
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (strings.length == 1) {
            return new BingoTeam(bingoPlg).getTeams();
        }
        return List.of();
    }
}
