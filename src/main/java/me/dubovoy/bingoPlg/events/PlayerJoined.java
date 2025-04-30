package me.dubovoy.bingoPlg.events;

import me.dubovoy.bingoPlg.BingoPlg;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.SQLException;

public class PlayerJoined implements Listener {

    private final BingoPlg bingoPlg;
    public PlayerJoined(BingoPlg bingoPlg) {this.bingoPlg = bingoPlg;}

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        try{
            if (bingoPlg.getDb().noPlayerInDb(player)) {
                bingoPlg.getDb().addPlayer(player);
                if (bingoPlg.bLog)
                    bingoPlg.LogIMsg(player.getName() + " Is added to Database");
            }
            else
                if (bingoPlg.bLog)
                    bingoPlg.LogIMsg(player.getName() + " Is already in Database");
        } catch (SQLException e) {
            bingoPlg.LogErrorsMsg(e);
        }
    }

}
