package me.dubovoy.bingoPlg.database;

import me.dubovoy.bingoPlg.BingoPlg;
import me.dubovoy.bingoPlg.Msg;
import org.bukkit.entity.Player;

import java.sql.SQLException;
import java.util.List;

public class BingoTeam {

    private final BingoPlg bingoPlg;
    public BingoTeam(BingoPlg bingoPlg) {this.bingoPlg = bingoPlg;}

    public String createTeam(String teamName){
        String success = null;

        try{
            if (bingoPlg.getDb().noTeamInDb(teamName)){
                bingoPlg.getDb().addTeam(teamName);
                if (bingoPlg.bLog)
                    bingoPlg.LogIMsg("Team <" + teamName + "> Was successfully added in Database");
                success = "§aКоманда \"" + teamName + "\" успешно зарегистрирована";
            } else {
                success = "§eЭта команда уже зарегистрирована";
                if (bingoPlg.bLog)
                    bingoPlg.LogIMsg("Team <" + teamName + "> Is already in Database");
            }

        } catch (SQLException e) {
            bingoPlg.LogErrorsMsg(e);
        }

        return success;
    }

    public String deleteTeam(String teamName){
        String success = null;

        try{
            if (bingoPlg.getDb().noTeamInDb(teamName)){
                success = "§eКоманды с таким названием не существует";
                if (bingoPlg.bLog)
                    bingoPlg.LogIMsg("Team <" + teamName + "> Was not removed form Database Case: No TeamName in DB");

            } else {
                bingoPlg.getDb().removeTeam(teamName);
                if (bingoPlg.bLog)
                    bingoPlg.LogIMsg("Team <" + teamName + "> Was successfully removed from Database");
                success = "§aКоманда \"" + teamName + "\" успешно удалена!";
            }

        } catch (SQLException e) {
            bingoPlg.LogErrorsMsg(e);
        }

        return success;
    }

    public String playerJoinTeam(Player player, String teamName){
        String success = null;

        try{
            if (!(bingoPlg.getDb().noTeamInDb(teamName))){
                int teamId = bingoPlg.getDb().getTeamByName(teamName);
                bingoPlg.getDb().updatePlayerTeam(player, teamId);
                success = "§aВы успешно добавлены в команду \"" + teamName + "\"";
                if (bingoPlg.bLog)
                    bingoPlg.LogIMsg("Player <" + player.getName() + "> Was successfully added in Team <" + teamName + ">");

            } else {
                success = "§eКоманды с таким названием не существует";
                if (bingoPlg.bLog)
                    bingoPlg.LogIMsg("Player <" + player.getName() + "> Was not added in Team <" + teamName + "> Case: No TeamName in DB");
            }

        } catch (SQLException e) {
            bingoPlg.LogErrorsMsg(e);
        }

        return success;
    }

    public List<String> getTeams(){
        List<String> success = null;
        try {
            success = bingoPlg.getDb().listTeams();

        } catch (SQLException e) {
            bingoPlg.LogErrorsMsg(e);
        }

        return success;
    }

}
