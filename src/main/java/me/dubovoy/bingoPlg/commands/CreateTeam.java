package me.dubovoy.bingoPlg.commands;

import me.dubovoy.bingoPlg.BingoPlg;
import me.dubovoy.bingoPlg.Msg;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.SQLException;
import java.util.List;

public class CreateTeam implements CommandExecutor, TabExecutor {

    private final BingoPlg bingoPlg;
    public CreateTeam(BingoPlg bingoPlg) {this.bingoPlg = bingoPlg;}

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (!(commandSender instanceof Player player)){
            Msg.send(commandSender, "Only players can use this command");
            return true;
        }

        if (strings.length != 1){
            Msg.send(player, "Введите название вашей команды!");
            return true;
        }

        String teamName = strings[0].toLowerCase();
        try{
            if (bingoPlg.getDb().noTeamInDb(teamName)){
                bingoPlg.getDb().addTeam(teamName);
                Msg.send(player, "Команда \"" + teamName + "\" успешно зарегистрирована", "&a");
                if (bingoPlg.bLog)
                    bingoPlg.LogIMsg("Team <" + teamName + "> Was successfully added in Database");

            } else {
                Msg.send(player, "Эта команда уже зарегистрирована", "&e");
                if (bingoPlg.bLog)
                    bingoPlg.LogIMsg("Team <" + teamName + "> Is already in Database");
            }

        } catch (SQLException e) {
            bingoPlg.LogErrorsMsg(e);
        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        return List.of();
    }
}
