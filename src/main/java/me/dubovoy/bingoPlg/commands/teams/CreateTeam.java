package me.dubovoy.bingoPlg.commands.teams;

import me.dubovoy.bingoPlg.BingoPlg;
import me.dubovoy.bingoPlg.Msg;
import me.dubovoy.bingoPlg.database.BingoTeam;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CreateTeam implements CommandExecutor, TabExecutor {

    private final BingoPlg bingoPlg;
    public CreateTeam(BingoPlg bingoPlg) {this.bingoPlg = bingoPlg;}

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {

        if (strings.length != 1){
            Msg.send(commandSender, "§eВведите название новой команды!");
            return true;
        }

        String teamName = strings[0].toLowerCase();
        BingoTeam bingoTeam = new BingoTeam(bingoPlg);
        String message = bingoTeam.createTeam(teamName);
        Msg.send(commandSender, message);

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        return List.of();
    }
}
