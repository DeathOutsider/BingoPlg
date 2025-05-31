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

public class DeleteTeam implements CommandExecutor, TabExecutor {

    private final BingoPlg bingoPlg;
    public DeleteTeam(BingoPlg bingoPlg) {this.bingoPlg = bingoPlg;}

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {

        if (strings.length != 1){
            Msg.send(commandSender, "§eВведите название команды для удаления!");
            return false;
        }

        if (commandSender instanceof Player ){
            if (!(commandSender.hasPermission("bingoPlg.delete_team"))){
                Msg.send(commandSender, "§eТолько оператор может пользоваться этой командой.");
                return true;
            }
        }

        String teamName = strings[0].toLowerCase();
        BingoTeam bingoTeam = new BingoTeam(bingoPlg);
        String message = bingoTeam.deleteTeam(teamName);
        Msg.send(commandSender, message);

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
