package me.dubovoy.bingoPlg.game;

import me.dubovoy.bingoPlg.BingoPlg;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BingoTable {

    private final BingoPlg bingoPlg;
    public BingoTable(BingoPlg bingoPlg) {this.bingoPlg = bingoPlg;}

    public void generateBingoTable(){
        try{
            int itemsCount = getGridSize() * getGridSize();
            int difficulty = getDifficulty();

            List<Integer> items = randomizeTable(difficulty);

            bingoPlg.getDb().setIdItemsForGame(items.subList(0, itemsCount+1));
            if (bingoPlg.bLog)
                bingoPlg.LogIMsg("Bingo Table Was Generated With Difficulty: " + difficulty + " Size: " + getGridSize());

        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }
    }

    public List<Integer> randomizeTable(int difficulty){
        List<Integer> items = new ArrayList<>();
        try{
            for (int i = 1; i < difficulty + 1; i++) {
                items.addAll(bingoPlg.getDb().getItemsIdForDifficulty(i));
            }

            Collections.shuffle(items);

        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }
        return items;
    }

    public ItemStack getItem(int id){
        try{
            return bingoPlg.getDb().getItemFromDb(id);
        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }
        return null;
    }

    public int getItemDifficulty(int id){
        try{
            return bingoPlg.getDb().getItemDifficulty(id);
        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }
        return 0;
    }

    public boolean isBingoTableExists(){
        try{
            return !bingoPlg.getDb().noTableInDb();

        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }
        return false;
    }


    public List<ItemStack> getBingoItems(){
        List<ItemStack> items = new ArrayList<>();
        try{
            items = bingoPlg.getDb().getItemsFromTable();

        } catch (Exception e) {
            bingoPlg.LogWMsg("FUNC GET BINGO ITEMS");
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

    public int[] checkBingoInvItems(ItemStack[] pInventory){
        List<Integer> invIndexes = new ArrayList<>();

        try{
            List<ItemStack> bingoItems = getBingoItems();
            List<String> invItems = new ArrayList<>();

            for (ItemStack itemStack: pInventory){
                if (itemStack == null)
                    continue;
                ItemStack isolated_item = itemStack.clone();
                Material material = isolated_item.getType();
                ItemMeta meta = isolated_item.getItemMeta();

                isolated_item.setAmount(1);
//                System.out.println(isolated_item);
                if (isolated_item.getDurability() > 0)
                    isolated_item.setDurability((short) 0);

                String keyList = material + "<meta>" + meta.getAsString();
                if (!invItems.contains(keyList)){
                    invItems.add(keyList);
                    if (bingoItems.contains(isolated_item)){
                        int ind = bingoItems.indexOf(isolated_item);
                        ind = convertIndToGui(ind);
                        invIndexes.add(ind);
                    }
                }
            }

        } catch (Exception e) {
            bingoPlg.LogErrorsMsg(e);
        }

        return invIndexes.stream().mapToInt(i->i).toArray();
    }
}
