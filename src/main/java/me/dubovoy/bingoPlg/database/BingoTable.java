package me.dubovoy.bingoPlg.database;

import me.dubovoy.bingoPlg.BingoPlg;
import me.dubovoy.bingoPlg.logic.Difficulty;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BingoTable {

    private final BingoPlg bingoPlg;
    public BingoTable(BingoPlg bingoPlg) {this.bingoPlg = bingoPlg;}

    public void createBingoTable(){
        try{
            int itemsCount = getGridSize() * getGridSize();
            int quality = getDifficulty();

            List<Material> items = new ArrayList<>();
//            List<Material> materials = Difficulty.readBingoFiles(bingoPlg.getDataFolder().getAbsolutePath(), quality);
            List<Material> materials = bingoPlg.getDb().getAllItemsForDifficulty(quality);
            Collections.shuffle(materials);
            for (int i = 0; i < itemsCount; i++) {
                items.add(materials.get(i));
            }
            bingoPlg.getDb().setBingoTablesItems(items);
        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }
    }

    public boolean isBingoTableExists(){
        try{
            List<Material> ls = bingoPlg.getDb().getBingoTableItems();
        } catch (Exception e) {
//            bingoPlg.LogErrorsMsg(e);
            return false;
        }
        return true;
    }


    public List<Material> getBingoItems(){
        List<Material> items = new ArrayList<>();
        try{
            items = bingoPlg.getDb().getBingoTableItems();

        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }
        return items;
    }

    public int getDifficulty(){
        int difficulty = bingoPlg.minDifficulty;
        try{
            difficulty = bingoPlg.getDb().getDifficulty();

        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }
        return difficulty;
    }

    public String setDifficulty(int difficulty){
        String message = null;
        if (difficulty < bingoPlg.minDifficulty | difficulty > bingoPlg.maxDifficulty){
            message = "Недопустимая сложность сетки!";
        } else
            try{
                bingoPlg.getDb().setDifficulty(difficulty);
                message = "Сложность Bingo теперь " + difficulty;
                if (bingoPlg.bLog)
                    bingoPlg.LogIMsg("Bingo Difficulty was set at " + difficulty);
            } catch (Exception e) {
                bingoPlg.LogErrorsMsg(e);
            }
        return message;
    }

    public int getGridSize(){
        int grid = 0;
        try{
            grid = bingoPlg.getDb().getGridSize();

        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }
        return grid;
    }

    public String setGridSize(int gridSize){
        String message = null;
        if (gridSize<=0 | gridSize>=7){
            message = "Недопустимый размер сетки!";
        } else
            try{
                bingoPlg.getDb().setGridSize(gridSize);
                message = "Сетка Bingo теперь " + gridSize + "x" + gridSize;
                if (bingoPlg.bLog)
                    bingoPlg.LogIMsg("Bingo Grid Size was set at " + gridSize);
            } catch (Exception e) {
                bingoPlg.LogErrorsMsg(e);
            }
        return message;
    }

    public String getBingoMode(){
        String mode = "CROSS";
        try{
            mode = bingoPlg.getDb().getBingoMode();

        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }
        return mode;
    }

    public String setBingoMode(String mode){
        String message = null;
        List<String> modes = new ArrayList<>();
        modes.add("CROSS");
        modes.add("TABLE");
        if (!modes.contains(mode)){
            message = "Недопустимый режим бинго!";
        } else
            try{
                bingoPlg.getDb().setBingoMode(mode);
                message = "Режим Bingo теперь " + mode;
                if (bingoPlg.bLog)
                    bingoPlg.LogIMsg("Bingo Mode was set at " + mode);
            } catch (Exception e) {
                bingoPlg.LogErrorsMsg(e);
            }
        return message;
    }

    public String getBingoItemsStringTable(){
        StringBuilder table = new StringBuilder();

        try{
            List<Material> items = bingoPlg.getDb().getBingoTableItems();
            int rowItems = bingoPlg.getDb().getGridSize();
            for (int i = 0; i < rowItems; i++) {
                for (int j = 0; j < rowItems; j++) {
                    table.append(items.get(i * rowItems + j).toString()).append(" ");
                }
                table.append("\n");
            }
        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }
        return table.toString();
    }

    public int convertIndToGui(int bingoInd) {
        int grid = getGridSize();
        int colInd = bingoInd % grid;
        int rowInd = bingoInd / grid;
        return colInd + rowInd * 9;
    }

    public int convertIndToTable(int guiInd) {
        int grid = getGridSize();
        int colInd = guiInd % 9;
        int rowInd = guiInd / 9;
        return colInd + rowInd * grid;
    }

    public int[] checkBingoInvItems(ItemStack[] pInventory, String mode){
        List<Integer> invIndexes = new ArrayList<>();

        try{
            List<Material> bingoItems = getBingoItems();
            List<Material> invItems = new ArrayList<>();
            List<Material> metas = new ArrayList<>();
            for (ItemStack itemStack: pInventory){
                Material material = itemStack.getType();
                ItemMeta meta = itemStack.getItemMeta();
                if (!invItems.contains(material)){

                    invItems.add(material);
                    if (bingoItems.contains(material)){
                        int ind = bingoItems.indexOf(material);
                        ind = convertIndToGui(ind);

//                        System.out.println(colInd);
//                        System.out.println(rowInd*6);
                        invIndexes.add(ind);
//                        System.out.println(ind);
//                        System.out.println(convertIndToTable(ind));
                    }
                }
            }
        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }

        return invIndexes.stream().mapToInt(i->i).toArray();
    }
}
