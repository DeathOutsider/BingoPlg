package me.dubovoy.bingoPlg.commands.teams;

import me.dubovoy.bingoPlg.BingoPlg;
import me.dubovoy.bingoPlg.Msg;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.SQLException;
import java.util.List;

public class TeleportTeam implements CommandExecutor, TabExecutor {

    private final BingoPlg bingoPlg;
    public TeleportTeam(BingoPlg bingoPlg) {this.bingoPlg = bingoPlg;}

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (!(commandSender instanceof Player player)){
            Msg.send(commandSender, "Only players can use this command");
            return true;
        }

        int tpX = 0;
        int tpY = 300;
        int tpZ = 0;

        if (strings.length < 1){
            Msg.send(player, "Введите название вашей команды!");
            return true;
        } else if (strings.length == 1){
            tpX = bingoPlg.RandomCoordinates();
            tpZ = bingoPlg.RandomCoordinates();
        }else if (strings.length == 2){
            Msg.send(player, "Введите 2 координаты для телепортации!");
            return true;
        } else if (strings.length == 3) {
            tpX = Integer.parseInt(strings[1]);
            tpZ = Integer.parseInt(strings[2]);
        }
        String teamName = strings[0].toLowerCase();

        try{
            if (!(bingoPlg.getDb().noTeamInDb(teamName))){
                int teamId = bingoPlg.getDb().getTeamByName(teamName);
                List<Player> teamPlayers = bingoPlg.getDb().listTeamPlayers(teamId);

                Location location = player.getLocation().set(tpX, tpY, tpZ);
                while (player.getWorld().getBlockAt(location).getType() == Material.AIR){
                    location.add(0, -1, 0);
                }
//                Location locationTp = location;
                Material platformBlock = Material.BEDROCK;
                location.getBlock().setType(platformBlock);
                int platform = 5;
                int axis = (-1 * platform/2);
                location.add(axis, 0, axis);

                for (int i = 0; i < platform; i++) {
                    for (int j = 0; j < platform; j++) {
                        for (int k = 0; k<2; k++){
                            location.add(0, 1, 0);
                            location.getBlock().setType(Material.AIR);
                        }
                        location.add(0, -2, 0);
                        location.getBlock().setType(platformBlock);
                        location.add(0, 0, 1);
                    }
                    location.add(0, 0, -1 * platform);
                    location.add(1, 0, 0);
                }

                location.add(axis-1,2,-axis);
                for (Player p: teamPlayers){
                    p.teleport(location);
                    Msg.send(p, "Ваша телепортация от команды \"" + teamName + "\" прошла успешно", "&a");
                    location.add(0, 1, 0);
                    p.setRespawnLocation(location, true);
                    p.getInventory().clear();
                    p.setHealth(0);
//                    Msg.send(p, "Ваша точка возрождения от команды \"" + teamName + "\" успешно установлена", "&a");
                    if (bingoPlg.bLog)
                        bingoPlg.LogIMsg("Player <" + p.getName() + "> Was successfully Teleported and Spawn Pointed with Team <" + teamName + "> " + "\nX:" + location.getX() + " Y:" + location.getY() + " Z:" + location.getZ());
                }

            } else {
                Msg.send(player, "Такой команды не существует", "&e");
                if (bingoPlg.bLog)
                    bingoPlg.LogIMsg("Player <" + player.getName() + "> Was not added in Team <" + teamName + "> Case: No TeamName");
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
                bingoPlg.LogErrorsMsg(e);
            }
        }
        return List.of();
    }
}
