package me.dubovoy.bingoPlg.handlers;

import me.dubovoy.bingoPlg.BingoPlg;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.SQLException;

public class playerJoined implements Listener {

    private final BingoPlg bingoPlg;
    public playerJoined(BingoPlg bingoPlg) {this.bingoPlg = bingoPlg;}

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        try{
            if (bingoPlg.getDb().noPlayerInDb(player))
                bingoPlg.getDb().addPlayer(player);

        } catch (SQLException e) {
            bingoPlg.LogErrorsMsg(e);
        }
    }

}
