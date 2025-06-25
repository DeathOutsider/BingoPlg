package me.dubovoy.bingoPlg.game;

import me.dubovoy.bingoPlg.BingoPlg;
import me.dubovoy.bingoPlg.Items.BingoItems;
import me.dubovoy.bingoPlg.Msg;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class BingoGame {
    private final BingoPlg bingoPlg;
    public BingoGame() {this.bingoPlg = BingoPlg.getInstance();}

    public void Start(){
        try {
            for (Player p: Bukkit.getOnlinePlayers()){
                ItemStack startItem = new BingoItems().BingoCompass();
                p.getInventory().clear();
                p.getInventory().addItem(startItem);
                p.setGameMode(GameMode.SURVIVAL);
                p.setHealthScale(20);
                p.setFoodLevel(20);
                p.playSound(p, Sound.ITEM_GOAT_HORN_SOUND_1, 100, 1);
                Msg.sendTitle(p, "§o§dBingo!", "§l§n§aНачалось!");
            }

            BingoTable table = new BingoTable(bingoPlg);
            if (!table.isBingoTableExists())
                table.generateBingoTable();

            if (bingoPlg.bLog)
                bingoPlg.LogIMsg("Game Bingo! Was Started");
        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }
    }

}
