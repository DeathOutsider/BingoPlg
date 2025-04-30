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

public class JoinTeam implements CommandExecutor, TabExecutor {

    private final BingoPlg bingoPlg;
    public JoinTeam(BingoPlg bingoPlg) {this.bingoPlg = bingoPlg;}

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
            if (!(bingoPlg.getDb().noTeamInDb(teamName))){
                int teamId = bingoPlg.getDb().getTeamByName(teamName);
                bingoPlg.getDb().updatePlayerTeam(player, teamId);
                Msg.send(player, "Вы успешно добавлены в команду \"" + teamName + "\"", "&a");
                if (bingoPlg.bLog)
                    bingoPlg.LogIMsg("Player <" + player.getName() + "> Was successfully added in Team " + teamName);

            } else {
                Msg.send(player, "Такой команды не существует", "&e");
                if (bingoPlg.bLog)
                    bingoPlg.LogIMsg("Player <" + player.getName() + "> Was not added in Team " + teamName + " Case: No TeamName");
            }

        } catch (SQLException e) {
            bingoPlg.LogErrorsMsg(e);
        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (strings.length == 1) {
            try {
                return bingoPlg.getDb().listTeams();
            } catch (SQLException e) {
//                Msg.send(commandSender, "Гильдии не загрузились(");
                bingoPlg.LogErrorsMsg(e);
            }
        }
        return List.of();
    }
}
